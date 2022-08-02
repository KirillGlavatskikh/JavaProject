package com.company.homework71;

public class MainString {

    private char[] chars;
    private int length;

    public static void main(String[] args) {
        Methods methods = new Methods("Hello");
        methods.StringLenght();
        methods.cleanString();
        methods.charsInString('e');
    }
}

class Methods {
    String str;

    public Methods() {
        System.out.println("Конструктор без значений");
    }

    public Methods(String str) {
        this.str = str;
    }

    public Methods(char symbol) {
    }

    public void StringLenght() {
        int lehght = str.length();
        System.out.println("Длина строки " + lehght);
    }

    public void cleanString() {
        StringBuilder builder = new StringBuilder(str);
        builder.delete(0, str.length());
        String result = builder.toString();
        System.out.println(result);
    }

    public void charsInString(char symbol) {
        int index = str.indexOf(symbol);
        System.out.println("Символ " + symbol + " найден на " + index + " индексе");
    }
}
