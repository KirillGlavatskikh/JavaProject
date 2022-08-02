package com.company;

public class Trenning {

    public static void main(String[] args) {
        //System.out.println(120 % 100);
        //System.out.println(100 / 100);
       // System.out.println();
        //System.out.println((1000 * 100 + 120) / 100 +"," + (1000 * 100 + 120) % 100);

        String str = "19.11.21";
        String [] arr = str.split("\\.");
        for (String s : arr) {
            System.out.println(s);
        }






    }
}









