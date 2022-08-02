package com.company.homework62;

public class Task09 {

    public static void main(String[] args) {

        System.out.println(theSumOfTheNumbersInTheRange(9));
    }
    private static int theSumOfTheNumbersInTheRange(int num){

        if(num == 5)
            return 5;
        return num + theSumOfTheNumbersInTheRange(num -1);
    }
}
