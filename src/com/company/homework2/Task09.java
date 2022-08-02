package com.company.homework2;

import java.util.Scanner;

public class Task09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число (дробное или целое)");
        double number = scanner.nextDouble() % 1;

        if (number > 0) {
            System.out.println("Число имеет вещественную часть");
        } else {
            System.out.println("Число не имеет вещественную часть");
        }


    }
}