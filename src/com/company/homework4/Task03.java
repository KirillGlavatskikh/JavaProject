package com.company.homework4;

public class Task03 {

    public static void main(String[] args) {

        for (int i = 10; i <= 1000000; i++) {
            char[] symbols = String.valueOf(i).toCharArray();
            int step = symbols.length;
            int armstrongNumber = 0;
            for (char symbol : symbols) {
                armstrongNumber += Math.pow(Character.getNumericValue(symbol), step);
            }
            if (armstrongNumber == i) {
                System.out.println(armstrongNumber);
            }

        }
    }
}
