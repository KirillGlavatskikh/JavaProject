package com.company.homework62;

public class Task07 {

    public static void main(String[] args) {

        String str = "radar";
        System.out.println(isTheWordAPalindrome(str) ? "YES" : "NO");
    }
    private static boolean isTheWordAPalindrome(String str){
        if(str.length() == 1 || str.length() == 0)
            return true;

        if(str.charAt(0) == str.charAt(str.length() - 1))
            return isTheWordAPalindrome(str.substring(1, str.length() -1 ));
        return false;
    }

}
