package com.company.homework2;

public class Task04 {

    public static void main(String[] args) {

        String str = "Hello world";

        char[] chars = str.toCharArray();

        for (char aChar : chars) {
            if (aChar == ' ')
            {
                continue;
            }
            System.out.print(aChar);
        }

    }
}
