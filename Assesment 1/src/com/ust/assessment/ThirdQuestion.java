package com.ust.assessment;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.util.Scanner;

public class ThirdQuestion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        System.out.println("Enter date to check");
        String userDate = sc.next();
        LocalDate date = LocalDate.parse(userDate);
        if (date.isEqual(today)) {
            System.out.println("The given date is today");
        }
        if (date.isAfter(today)) {
            System.out.println("The given date is after today");

        } else
        {
            System.out.println("The given date is before today");

        }



    }
}
