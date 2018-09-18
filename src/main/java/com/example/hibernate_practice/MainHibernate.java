package com.example.hibernate_practice;

import com.example.hibernate_practice.entity.Exam;
import com.example.hibernate_practice.entity.Student;
import com.example.hibernate_practice.entity.StudentAddress;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static com.example.dmitrii.spring_practice.ansi_colors.Colors.*;

@Component("hibernateBean")
public class MainHibernate implements DisposableBean, InitializingBean {

    public MainHibernate() {

    }

    public void main() {
        Scanner scanner = new Scanner(System.in);
        //BUILDING SESSIONFACTORY AND OPENING NEW SESSION
        Session session = HibernateUtility.getHibernateSession();
        Transaction transaction = session.beginTransaction();

        boolean checker = true;
        while (checker) {
            System.out.println(ANSI_RESET + ANSI_GREEN + "Select what you want to do with DATABASE\n" +
                    "1.Insert\n" +
                    "2.Update grades\n" +
                    "3.Delete\n" +
                    "4.Nothing. I'm done. Exit.");
            while(!scanner.hasNextInt()){
                System.out.println("That's not a number!");
                scanner.next();
            }
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    session.save(addStudentInfo(scanner));
                    break;
                case 2:
                    TypedQuery<Student> query = session.createQuery("from Student", Student.class);
                    List<Student> students = query.getResultList();
                    for (Student student : students) {
                        student = setStudentExams(session, student.getId(), scanner);
                        session.save(student);
                        System.out.println(ANSI_CYAN + student.getExams() + ANSI_RESET);
                    }
                    break;
                case 3:
                    System.out.println("Enter last_name of user you want to delete");
                    String tmp = scanner.next();
                    TypedQuery<Student> query1 = session.createQuery("FROM Student", Student.class);
                    List<Student> students1 = query1.getResultList();
                    for (Student student1 : students1) {
                        if (student1.getLastName().toLowerCase().equals(tmp.toLowerCase())) {
                            session.delete(student1);
                            session.flush();
                            System.out.printf(ANSI_RED + "User with lastname %s was successfully deleted from DATABASE\n" + ANSI_RESET, tmp);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ok...\nTerminating..." + ANSI_RESET);
                    checker = false;
                    break;
                default:
                    System.out.println("Wrong answer...\nTry again...");
                    break;
            }

        }
        transaction.commit();
        session.close();
        scanner.close();
        HibernateUtility.closeSessionFactory();
    }


    private static Student addStudentInfo(@NotNull Scanner scan) {
        Student student = new Student();

        System.out.println("Enter student's f_name");
        student.setFirstName(scan.next());

        System.out.println("Enter student's l_name");
        student.setLastName(scan.next());

        System.out.println("Enter student's age");
        int age;
        do {
            while (!scan.hasNextInt()) {
                System.out.println("This is not a number. Please enter valid age!");
                scan.next();
            }
            age = scan.nextInt();
        } while (age < 1 || age > 150);
        student.setAge(age);

        StudentAddress studentAddress = new StudentAddress();

        System.out.println("Enter student's city");
        studentAddress.setCity(scan.next());

        System.out.println("Enter student's country");
        studentAddress.setCountry(scan.next());

        System.out.println("Enter student's address");
        scan.skip("\n");
        studentAddress.setAddress(scan.nextLine());

        student.setStudentAddress(studentAddress);
        return student;
    }

    private static Student setStudentExams(@NotNull Session session, int student_id, @NotNull Scanner scanner) {
        Student student = session.get(Student.class, student_id);
        Set<Exam> exams = student.getExams();
        System.out.println("Select which exam grade you want to change...");
        int selectedExam = scanner.nextInt();
        for (Exam exam : exams) {
            if (exam.getSubject().getId() == selectedExam) {
                System.out.println("Enter new mark for this exam...");
                exam.setGrade(scanner.nextInt());
            }
        }
        student.setExams(exams);
        return student;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
