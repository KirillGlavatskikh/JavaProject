package com.company.homework4;

public class Task11 {

    public static void main(String[] args) {

        for (int value = 1; value <= 1000; value++) {
            if (value % 15 == 0) {
                System.out.println("hiss");
            } else if (value % 3 == 0) {
                System.out.println("fizz");
            } else if (value % 5 == 0) {
                System.out.println("buzz");
            }
            System.out.println(value);
        }
    }
}
