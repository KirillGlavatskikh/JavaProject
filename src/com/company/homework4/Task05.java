package com.company.homework4;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {

        int expression;
        int newNumber = 0;
        int number;
        int number1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        number = scanner.nextInt();
        number1 = number;

        while (number != 0) {
            expression = number % 10;
            newNumber = (newNumber * 10) + expression;
            number = number / 10;
        }

        if (number1 == newNumber) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
