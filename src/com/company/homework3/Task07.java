package com.company.homework3;

import java.util.Locale;
import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number or letter");
        String symbol = scanner.next();

        String[] latinSmall = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
        String[] latinBig = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
        String[] kirilSmall = {"й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ъ", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю"};
        String[] kirilBig = {"Й", "Ц", "У", "К", "Е", "Н", "Г", "Ш", "Щ", "З", "Х", "Ъ", "Ф", "Ы", "В", "А", "П", "Р", "О", "Л", "Д", "Ж", "Э", "Я", "Ч", "С", "М", "И", "Т", "Ь", "Б", "Ю"};
        String[] number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        for (String x : latinSmall) {
            if (x.equals(symbol)) {
                System.out.println("Латиница");
            }
        }
        for (String x : latinBig) {
            if (x.equals(symbol)) {
                System.out.println("Латиница");
            }
        }
        for (String x : kirilSmall) {
            if (x.equals(symbol)) {
                System.out.println("Кирилица");
            }
        }
        for (String x : kirilBig) {
            if (x.equals(symbol)) {
                System.out.println("Кирилица");
            }
        }
        for (String x : number) {
            if (x.equals(symbol)) {
                System.out.println("Цифра");
            } else {
                System.out.println("Невозможно определить");
                break;
            }
        }
    }
}





