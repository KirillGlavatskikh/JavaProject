package com.company.homework74;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayList<>(2);
        myArrayList.pushBack("Hello");
        myArrayList.pushBack("World");
        System.out.println(Arrays.toString(myArrayList.getData()));
        System.out.println(myArrayList.getSize());
        myArrayList.indexOf("World");
        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.indexOf("World"));
    }
}
