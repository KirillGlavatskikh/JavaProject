package com.company.homework3;

import java.util.Scanner;

public class Task10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество подъездов ");
        int numberOfEntrances = scanner.nextInt();
        System.out.print("Введите количество квартир на этаже ");
        int apartmentsOnTheFloor = scanner.nextInt();
        System.out.print("Введите номер квартиры ");
        int apartmentNumber = scanner.nextInt();

        int apartmentInEntrances = apartmentsOnTheFloor * 9;
        int apartmentInHome = apartmentInEntrances * numberOfEntrances;

        int entrances = 1;
        do {
            if (apartmentNumber <= apartmentInEntrances) {
                System.out.println("Квартира № " + apartmentNumber + " находится в " + entrances + " подъезде");
                break;
            }
            entrances++;
        } while (entrances <= numberOfEntrances);
        System.out.println("Квартира № " + apartmentNumber + " находится в " + entrances + " подъезде");


    }
}
