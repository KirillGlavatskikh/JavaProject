package com.company.homework5;

import java.io.IOException;
import java.util.Scanner;
        // ¬вести с клавиатуры строку текста, а затем один символ.
        //ѕоказать на консоль индексы и количество совпадений (ищем
        //вхождени€ символа в строку). ¬ случае если совпадений не
        //найдено, вывести соответствующий текст.
public class Task01 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the text");
        String text = scanner.nextLine();
        System.out.println("Enter the symbol");
        int enterSymbol = System.in.read();
        char symbol = (char) enterSymbol;
        char[] ch = text.toCharArray();
        int counter = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == symbol) {
                System.out.println("The symbol is located under the index " + i);
                counter++;
            }
        }
        System.out.println("Number of occurrences in the text: " + counter);
    }
}
