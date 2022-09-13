package com.company.pattern;

public class Main {

    public static void main(String[] args) {

        Car car = new CarBuilder()
                .name("Ford")
                .color("Black")
                .enginePower(120L)
                .transmission("Mehanica")
                .build();
        System.out.println(car);

        Car car1 = new CarBuilder()
                .name("Lada granta")
                .color("White")
                .enginePower(87L)
                .transmission("Mehanica")
                .build();
        System.out.println(car1);

        Car car2 = new CarBuilder()
                .name("Toyota")
                .color("Grey")
                .enginePower(150L)
                .transmission("Automatic")
                .build();
        System.out.println(car2);
    }
}
