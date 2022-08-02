package com.company.homework3;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the day of the week");
        int daysWeek = scanner.nextInt();

        switch (daysWeek) {
            case 1 -> System.out.println("1 - it's monday");
            case 2 -> System.out.println("2 - it's tuesday");
            case 3 -> System.out.println("3 - it's wednesday");
            case 4 -> System.out.println("4 - it's thursday");
            case 5 -> System.out.println("5 - it's friday");
            case 6 -> System.out.println("6 - it's saturday");
            case 7 -> System.out.println("7 - it's sunday");
        }

    }
}
