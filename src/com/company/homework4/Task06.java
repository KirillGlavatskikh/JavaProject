package com.company.homework4;

public class Task06 {

    public static void main(String[] args) {

        int countNumber = 0;

        for (int i = 10000000; i < 99999999; i++) {
            if (i % 123456 == 0) {
                String iString = String.valueOf(i);
                char[] chars = iString.toCharArray();

                boolean isUniqNumbers = false;

                for (int j = 0; j < chars.length; j++) {
                    if (iString.indexOf(chars[j]) != j) {
                        isUniqNumbers = false;
                        break;
                    } else {
                        isUniqNumbers = true;
                    }
                    if (isUniqNumbers) {
                        countNumber++;
                        System.out.println(i);
                    }
                }
            }
        }
        System.out.println("Общее количество - " + countNumber);
    }
}
