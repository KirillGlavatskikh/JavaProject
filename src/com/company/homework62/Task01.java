package com.company.homework62;

public class Task01 {

    public static void main(String[] args) {

        allNumbersFromAtoB(10, 1);

    }

    private static void allNumbersFromAtoB(int numA, int numB) {

        if (numA < numB) {
            System.out.print(numA);
            allNumbersFromAtoB(numA + 1, numB);
        }
        if (numA > numB) {
            System.out.print(numA);
            allNumbersFromAtoB(numA - 1, numB);
        }


    }

}
