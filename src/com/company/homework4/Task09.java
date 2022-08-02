package com.company.homework4;

public class Task09 {

    public static void main(String[] args) {

        int sum = 0;
        int number;

        for (number = 0; number < 1000; number++) {
            if (number % 3 == 0.0 || number % 5 == 0.0) {

                sum += number;

            }
        }
        System.out.println(sum);

    }
}
