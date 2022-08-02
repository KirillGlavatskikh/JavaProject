package com.company.homework2;

import java.util.Scanner;

public class Task10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваш рост");
        final int HEIGHT = scanner.nextInt();
        System.out.println("Введите ваш вес");
        final int WEIGHT = scanner.nextInt();

        int idealWeight = HEIGHT - 110;
        int result = WEIGHT - idealWeight;

        if (result > 0){
            System.out.println("Вам нужно скинуть " + result);
        }else{
            System.out.println("Вам нужно набрать " + Math.abs(result));
        }



    }
}
