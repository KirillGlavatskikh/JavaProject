package com.company.homework3;

import java.util.Scanner;

public class Task08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number");
        int xNumber = scanner.nextInt();
        System.out.println("Enter the second number");
        int yNumber = scanner.nextInt();

        xNumber = xNumber % 2;
        yNumber = yNumber % 2;

        if (xNumber == 0 & yNumber == 0) {
            System.out.println("YES");
        }
        if (xNumber == 1 & yNumber == 1) {
            System.out.println("YES");
        }
    }
}
