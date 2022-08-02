package com.company.homework62;

public class Task03 {

    public static void main(String[] args) {

        System.out.println(sumOfNumbers(179));
    }

    private static int sumOfNumbers(int num) {
        if(num == 0)
            return 0;

        return sumOfNumbers(num / 100) + (num / 10 % 10) + (num % 10);
    }
}