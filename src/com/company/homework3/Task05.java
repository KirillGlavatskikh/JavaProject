package com.company.homework3;

import java.util.Scanner;

public class Task05 {

    static String zodiacSign = "";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the year of birth ");
        int yearBirth = scanner.nextInt();
        System.out.print("Enter the month of birth ");
        int monthBirth = scanner.nextInt();
        System.out.print("Enter the day of birth ");
        int dayBirth = scanner.nextInt();

        System.out.println("Вывод:");

        switch (monthBirth) {
            case 1:
                zodiacSign = (dayBirth <= 20) ? "Козерог" : "Водолей";
                break;
            case 2:
                zodiacSign = (dayBirth <= 19) ? "Водолей" : "Рыбы";
                break;
            case 3:
                zodiacSign = (dayBirth <= 20) ? "Рыбы" : "Овен";
                break;
            case 4:
                zodiacSign = (dayBirth <= 20) ? "Овен" : "Телец";
                break;
            case 5:
                zodiacSign = (dayBirth <= 21) ? "Телец" : "Близнецы";
                break;
            case 6:
                zodiacSign = (dayBirth <= 21) ? "Близнецы" : "Рак";
                break;
            case 7:
                zodiacSign = (dayBirth <= 22) ? "Рак" : "Лев";
                break;
            case 8:
                zodiacSign = (dayBirth <= 23) ? "Лев" : "Дева";
                break;
            case 9:
                zodiacSign = (dayBirth <= 23) ? "Дева" : "Весы";
                break;
            case 10:
                zodiacSign = (dayBirth <= 23) ? "Весы" : "Скорпион";
                break;
            case 11:
                zodiacSign = (dayBirth <= 22) ? "Скорпион" : "Стрелец";
                break;
            case 12:
                zodiacSign = (dayBirth <= 23) ? "Стрелец" : "Козерог";
                break;
        }
        System.out.println("Знак:" + zodiacSign);
        {
            int finalYearBirth = yearBirth % 12;
            switch (finalYearBirth) {
                case 1 -> System.out.println("Год: Петуха");
                case 2 -> System.out.println("Год: Собаки");
                case 3 -> System.out.println("Год: Свиньи");
                case 4 -> System.out.println("Год: Крысы");
                case 5 -> System.out.println("Год: Быка");
                case 6 -> System.out.println("Год: Тигра");
                case 7 -> System.out.println("Год: Кролика");
                case 8 -> System.out.println("Год: Дракона");
                case 9 -> System.out.println("Год: Змеи");
                case 10 -> System.out.println("Год: Лошади");
                case 11 -> System.out.println("Год: Козы");
                case 0 -> System.out.println("Год: Обезьяны");
            }

        }
    }
}