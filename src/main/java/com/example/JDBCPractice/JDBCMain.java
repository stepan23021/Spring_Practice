package com.example.JDBCPractice;

import java.sql.*;
import java.util.Scanner;
import static com.example.dmitrii.spring_practice.ansi_colors.Colors.*;

public class JDBCMain {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hibernatePractice?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "1111";
    private static Connection connection = null;
    private static Statement statement = null;

    private static void updateSQL(int id, String last_name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET lastname=? where id = ?");
        preparedStatement.setInt(2, id);
        preparedStatement.setString(1, last_name);
        preparedStatement.executeUpdate();
        execSQL();
    }

    private static void insertSQL(String first_name, String last_name, int age) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students(firstname,lastname,age) values (?,?,?)");
        preparedStatement.setString(1, first_name);
        preparedStatement.setString(2, last_name);
        preparedStatement.setInt(3, age);
        preparedStatement.execute();
        execSQL();
    }

    private static void deleteSQL(String last_name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE lastname=?");
        preparedStatement.setString(1, last_name);
        preparedStatement.execute();
        System.out.println(ANSI_RED + "Successfully deleted user with last_name " + "\"" + last_name + "\"" + ANSI_RESET);
        execSQL();
    }

    private static void execSQL() throws SQLException {
        String sql;
        sql = "select * from students";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String f_name = rs.getString("firstname");
            String l_name = rs.getString("lastname");
            System.out.printf(ANSI_GREEN + "ID is %d, Age is %d, First name - %s, Last Name - %s%n" + ANSI_RESET, id, age, f_name, l_name);
        }
        rs.close();
    }

    public static void main(String[] args) {
        boolean checker = false;
        int option;
        while (!checker) {
            try {
                Class.forName(JDBC_DRIVER);
                System.out.println("Connecting to database...");
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Creating statement...");
                statement = connection.createStatement();
                System.out.println("Select what you want to do with DATABASE\n" +
                        "1.Update\n" +
                        "2.Insert\n" +
                        "3.Delete\n" +
                        "4.Nothing. Exit.");
                option = new Scanner(System.in).nextInt();

                if (option >= 1 && option <= 4) {
                    switch (option) {
                        case 1:
                            System.out.println("Введите ID пользователя, затем фамилию");
                            updateSQL(new Scanner(System.in).nextInt(), new Scanner(System.in).next());
                            break;
                        case 2:
                            System.out.println("Insert user with firstname, lastname and age");
                            insertSQL(new Scanner(System.in).next(),
                                    new Scanner(System.in).next(),
                                    new Scanner(System.in).nextInt());
                            break;
                        case 3:
                            System.out.println("Enter person's lastname you wan't to delete");
                            deleteSQL(new Scanner(System.in).next());
                            break;
                        case 4:
                            System.out.println("Terminating...");
                            checker = true;
                            break;
                    }
                    System.out.println("asdasdadada");
                    statement.close();
                    connection.close();

                } else {
                    System.out.println("Terminating...");
                    checker = true;
                }

            } catch (SQLException | ClassNotFoundException se) {
                se.printStackTrace();
            }
        }
    }
}

