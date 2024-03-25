package com.ust.assessment;

import java.util.Scanner;

public class SecondQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.println("Enter the dividend");
            int dividend = sc.nextInt();
            System.out.println("Enter the divisor");
            int divisor = sc.nextInt();
            if (divisor == 0) {
                throw new InvalidInputException("Please pass a valid divisor");
            }
            int result = dividend/divisor;
            System.out.println("Result"+result);


        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
