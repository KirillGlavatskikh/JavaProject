package com.company.homework4;

public class Task10 {

    public static void main(String[] args) {

        boolean value = false;

        for (int number = 1; number < Integer.MAX_VALUE; number++) {
            for (int devider = 1; devider <= 20; devider++) {

                if (number % devider == 0) {
                    value = true;
                } else {
                    value = false;
                    break;
                }
            }
            if (value) {
                System.out.println(number);
                break;
            }
        }
    }
}