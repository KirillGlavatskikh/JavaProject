package com.company.homework4;

public class Task08 {

    public static void main(String[] args) {

        int count = 0;
        for (int hour = 1; hour < 24; hour++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                if (hour / 10 % 10 == minutes % 10 & hour % 10 == minutes / 10 % 10) {
                    System.out.println(hour + ":" + minutes);
                    count++;
                }
            }
        }
        System.out.println("Всего " + count + " совадений");

    }
}

