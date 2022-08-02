package com.company.homework3;

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the hour from 0 to 24");
        int hour = scanner.nextInt();

        switch (hour) {
            case 0, 1, 2, 3, 4, 5, 6:
                System.out.println("Good night");
                break;
            case 7, 8, 9, 10, 11, 12:
                System.out.println("Good morning");
                break;
            case 13, 14, 15, 16, 17, 18:
                System.out.println("Good afternoon");
                break;
            case 19, 20, 21, 22, 23, 24:
                System.out.println("Good evening");
                break;

        }

    }
}
