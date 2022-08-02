package com.company.homework3;

import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a six-digit number");
        int number = scanner.nextInt();

        int value1 = number / 100000;
        int value2 = (number / 10000) % 10;
        int value3 = (number / 1000) % 10;
        int value4 = (number / 100) % 10;
        int value5 = (number / 10) % 10;
        int value6 = number % 10;

        System.out.println("Вывод");

        if (value1 + value2 + value3 == value4 + value5 + value6) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
