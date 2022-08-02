package com.company.homework4;

public class Task04 {

    public static void main(String[] args) {

        for (int min = 1; min <= 1000000; min++) {
            int sum = 0;
            for (int e = 1; e < min; e++) {
                if ((min % e) == 0) {
                    sum += e;
                }
            }
            if (sum == min) {
                System.out.println(sum);
            }
        }
    }
}