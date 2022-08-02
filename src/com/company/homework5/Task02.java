package com.company.homework5;

import java.util.Arrays;
import java.util.Scanner;

//Написать программу, которая создаст строку, в которой
//находятся все целые числа, начиная с 1, выписаны в одну
//строку «123456789101112131415...». Строка должна быть
//длиной не более 1 000 символов.
//По числу n (введенного с клавиатуры), выведите цифру на
//n-й позиции (используется нумерация с 1).
public class Task02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        //int number = scanner.nextInt();
        int[] value = new int[1000];
        for(int i = 1; i < value.length ; i++){
            value[i] = i;
        }
        String str = Arrays.toString(value);
        int initialValue = 0;
        int lastValue = 1001;
        char[] newValue = new char [1001];
        str.getChars(0,1001,newValue,0);




    }
}
