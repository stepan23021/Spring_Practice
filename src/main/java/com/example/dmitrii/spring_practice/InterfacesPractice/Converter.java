package com.example.dmitrii.spring_practice.InterfacesPractice;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_RED;
import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_RESET;

/**
 * @author Dmitrii Stepcenco
 * @created 12 September 2018
 **/

public class Converter {
    public static void main(String[] args) throws IOException {
        JSONParser jsonParser = new JSONParser();
        jsonParser.getRates();
        String cur1 = "";
        String cur2 = "";
        int value;
        double answer = 0.0;
        boolean tmp = true;
        while (tmp) {
            System.out.println("Please, select which currency you want to convert\n" +
                    "1.Dollar\n" +
                    "2.Euro\n" +
                    "3.Ruble\n" +
                    "4.MDL\n" +
                    "5.Exit");
            int currency1 = new Scanner(System.in).nextInt();
            if (currency1 == 5) {
                System.out.println("Terminating...");
                tmp = false;
            } else if (currency1 > 5) {
                System.out.println("Wrong answer, try again...");
            } else {
                System.out.println("Enter value");
                value = new Scanner(System.in).nextInt();
                System.out.println("Please specify to which currency you want to convert\n" +
                        "1.Dollar\n" +
                        "2.Euro\n" +
                        "3.Ruble\n" +
                        "4.MDL\n" +
                        "5.Exit");
                int currency2 = new Scanner(System.in).nextInt();
                switch (currency1) {
                    case 1:
                        cur1 = "dollars";
                        Dollars dollars = new Dollars();
                        answer = dollars.convertToMDL(value);
                        break;
                    case 2:
                        cur1 = "euro";
                        Euro euro = new Euro();
                        answer = euro.convertToMDL(value);
                        break;
                    case 3:
                        cur1 = "ruble";
                        Ruble ruble = new Ruble();
                        answer = ruble.convertToMDL(value);
                        break;
                    case 4:
                        cur1 = "MDL";
                        answer = value;
                        break;
                    default:
                        System.out.println("Wrong answer. Try again...");
                        break;
                }
                switch (currency2) {
                    case 1:
                        cur2 = "dollars";
                        Dollars dollars = new Dollars();
                        answer = dollars.convertFromMDL(answer);
                        break;
                    case 2:
                        cur2 = "euro";
                        Euro euro = new Euro();
                        answer = euro.convertFromMDL(answer);
                        break;
                    case 3:
                        cur2 = "rubles";
                        Ruble ruble = new Ruble();
                        answer = ruble.convertFromMDL(answer);
                        break;
                    case 4:
                        cur2 = "MDL";
                        break;
                    case 5:
                        tmp = false;
                        break;
                    default:
                        System.out.println("Wrong answer. Try again");
                        break;
                }
                DecimalFormat format = new DecimalFormat("##.00");
                String ans = (format.format(answer));
                System.out.printf(ANSI_RED + "The result of converting %d %s to %s is %s\n\n" + ANSI_RESET, value, cur1, cur2, ans);
            }
        }

    }
}
