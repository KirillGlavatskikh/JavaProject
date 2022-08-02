package com.company.homework2;

public class Task05 {

    public static void main(String[] args) {

        final double RADIUS = 4;

        double lenght = 2 * Math.PI * RADIUS;
        System.out.print("Длина окружности: ");
        System.out.printf("%.3f", lenght);
        System.out.println();

        double s = Math.PI * Math.pow(RADIUS, 2);
        System.out.print("Площадь окружности: ");
        System.out.printf("%.3f", s);
    }
}
