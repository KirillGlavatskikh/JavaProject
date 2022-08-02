package com.company.homework4;

public class Task01 {

    public static void main(String[] args) {

        int valueF1 = 0;
        int valueF2 = 1;
        int valueF3;

        while (valueF2 <= 10000000) {
            valueF3 = valueF1 + valueF2;
            valueF1 = valueF2;
            valueF2 = valueF3;
            System.out.print(" " + valueF1 + " ");
        }
    }
}
