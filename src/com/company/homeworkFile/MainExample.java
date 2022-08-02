package com.company.homeworkFile;

import java.io.*;
import java.util.Arrays;

public class MainExample {

    public static void main(String[] args) {

        Example example1 = new Example(1, "Vasya");
        Example example2 = new Example(2, "Petya");
        Example example3 = new Example(3, "Sasha");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/Java Project/src/com/company/homeworkFile/Book.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/Java Project/src/com/company/homeworkFile/Book.txt"))) {

            oos.writeObject(example1);
            oos.writeObject(example2);
            oos.writeObject(example3);

            System.out.println(ois.available());

            Example[] arr = new Example[ois.available()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (Example) ois.readObject();

            }
            System.out.println(Arrays.toString(arr));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
}
