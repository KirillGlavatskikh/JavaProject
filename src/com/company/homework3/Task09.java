package com.company.homework3;

import java.util.Scanner;

public class Task09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first coordinates");
        System.out.print("Coordinate X ");
        double coordinateX = scanner.nextDouble();
        System.out.print("Coordinate Y ");
        double coordinateY = scanner.nextDouble();
        System.out.println("Enter the second coordinates");
        System.out.print("Coordinate X1 ");
        double coordinateX1 = scanner.nextDouble();
        System.out.print("Coordinate Y1 ");
        double coordinateY1 = scanner.nextDouble();

        if (coordinateX1 > coordinateX & coordinateY1 > coordinateY) {
            System.out.println("Подъем");
        }
        if (coordinateX > coordinateX1 & coordinateY > coordinateY1) {
            System.out.println("Спуск");
        }
        if (coordinateX < coordinateX1 & coordinateY == coordinateY1) {
            System.out.println("Рованя дорога");
        }
        if (coordinateX == coordinateX1 & coordinateY < coordinateY1) {
            System.out.println("Отвесная дорога");
        }
    }
}
