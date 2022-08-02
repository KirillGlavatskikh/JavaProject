package com.company.homework3;

import java.util.Scanner;

public class Task06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the year");
        int year = scanner.nextInt();

        if (year % 4 == 0) {
            System.out.println("There are 366 days in a year");
        } else {
            System.out.println("There are 365 days in a year");
        }
    }
}
