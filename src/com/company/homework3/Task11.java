package com.company.homework3;

import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значение переменных a, b, c, при это а не должно равняться нулю.");
        System.out.print("Значение а ");
        int valueA = scanner.nextInt();
        System.out.print("Значение b ");
        int valueB = scanner.nextInt();
        System.out.print("Значение с ");
        int valueC = scanner.nextInt();
        int discriminant = (int) Math.pow(valueB, 2) - 4 * valueA * valueC;

        if (discriminant > 0) {
            int x1 = (int) (-valueB + Math.sqrt(discriminant)) / 2 * valueA;
            int x2 = (int) (-valueB - Math.sqrt(discriminant)) / 2 * valueA;
            System.out.println("Уравнение имеет два корня: Х1 = " + x1 + " X2 = " + x2);
        } else if (discriminant < 0) {
            int x1 = (int) (-valueB + Math.sqrt(discriminant)) / 2 * valueA;
            System.out.println("Уравнение имеет один корень: Х = " + x1);
        } else if (discriminant == 0) {
            System.out.println("Корней нет");
        }


    }
}
