package com.company;

import java.util.Scanner;

public class Calculator {

    private static final String CONCATENATION = "+";
    private static final String DIFF = "-";
    private static final String MULT = "*";
    private static final String SUB = "/";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        double first = scanner.nextDouble();
        System.out.println("Введите второе число");
        double second = scanner.nextDouble();

        System.out.println("Выберите ариметическое действие");

        String operation = scanner.next();

        switch (operation) {
            case CONCATENATION:
                System.out.println(first + second);
                break;
            case DIFF:
                System.out.println(first - second);
                break;
            case MULT:
                System.out.println(first * second);
                break;
            case SUB:
                System.out.println(first / second);
                break;
        }
    }
}
