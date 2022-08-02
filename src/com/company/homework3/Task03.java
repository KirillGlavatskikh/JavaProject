package com.company.homework3;

import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите животное из списка: 1-кошка, 2-собака, 3-волк, 4-лягушка, 5-свинья, 6-овца, 7-мышь, 8-корова, 9-лошадь, 10-слон");
        int animals = scanner.nextInt();

        switch (animals) {
            case 1 -> System.out.println("Кошка мяукает");
            case 2 -> System.out.println("Собака гавкает");
            case 3 -> System.out.println("Волк воет");
            case 4 -> System.out.println("Лягушка квакает");
            case 5 -> System.out.println("Свинья хрюкает");
            case 6 -> System.out.println("Овца блеет");
            case 7 -> System.out.println("Мышь пищит");
            case 8 -> System.out.println("Корова мычит");
            case 9 -> System.out.println("Лошадь ржет");
            case 10 -> System.out.println("Слон трубит");
        }

    }
}
