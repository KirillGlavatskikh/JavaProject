package com.company;

public class Operator {


    public static void main(String[] args) {


        String number = "0";
        for(int i = 0;; i++){
            number += i;
            if(number.length() <= 1000){
                System.out.println(number);
            }
        }
    }
}



