package com.company.homework4;

public class Task02 {

    public static void main(String[] args) {

        for (int i = 2; i <= 1000000; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}
