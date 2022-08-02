package com.company.homework2;

public class Task02 {

    public static void main(String[] args) {

        int n = 654;
        int first = (n -(n%100)) / 100;
        int second = (n % 100) / 10;
        int third = n % 10;

        System.out.println(first + second + third);
    }
}
