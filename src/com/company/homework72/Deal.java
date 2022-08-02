package com.company.homework72;

import java.util.Scanner;

public class Deal extends Worker {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private int sum;

    public Deal(String name) {

        this.name = name;
    }

    @Override
    public int deal(int payWork, int timeWork) {
        return this.sum = payWork * timeWork;
    }

    public String toString() {

        return name + " deal " + sum;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public int Tax() {
        System.out.println("Does " + name + " have children?(true or false)");
        boolean children = scanner.nextBoolean();
        if (children) {
            sum -= (sum / 100 * 15);
        } else {
            sum -= (sum / 100 * 20);
        }
        return sum;
    }

    @Override
    public void printPayTax() {
        System.out.println("Including tax: " + name + " = " + Tax());
    }
}
