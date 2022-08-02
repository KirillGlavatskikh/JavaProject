package com.company.homework3;

import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of the X coordinate from -10 to 10");
        int valueX = scanner.nextInt();
        System.out.println("Enter the value of the Y coordinate from -10 to 10");
        int valueY = scanner.nextInt();

        if (valueX > 0 & valueY > 0) {
            System.out.println("The point is in 1 quarter");
        } else if (valueX < 0 & valueY < 0) {
            System.out.println("The point is in 3 quarter");
        } else if (valueX > 0 & valueY < 0) {
            System.out.println("The point is in 4 quarter");
        } else if (valueX < 0 & valueY > 0) {
            System.out.println("The point is in 2 quarter");
        } else if (valueX == 0 & valueY != 0) {
            System.out.println("The point is on the abscissa line");
        } else if (valueX != 0 & valueY == 0) {
            System.out.println("The point is on the ordinate line");
        }
    }
}
