package com.company.homework4;

import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the athletes mileage");
        int mileage = scanner.nextInt();
        int firstDay = 10;
        int counter = 0;
        int[] array = new int[mileage];
        for (firstDay = 10; firstDay < array.length; firstDay += firstDay / 10) {
            array[firstDay] = firstDay;
            counter++;
        }
        System.out.println("The run of " + mileage + "kilometers well be on the " + counter + "th day");

    }
}
