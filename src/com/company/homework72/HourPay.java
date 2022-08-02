package com.company.homework72;

import java.util.Scanner;

public class HourPay extends Worker {

    Scanner scanner = new Scanner(System.in);

    private String name;
    private int sum;

    public HourPay(String name) {
        this.name = name;
    }

    @Override
    public int hourPay(int payWork, int timeWork) {
        return this.sum = payWork * timeWork;
    }


    public String toString() {
        return name + " hourpay " + sum;
    }

    @Override
    public int Tax() {
        System.out.println("Does " + name + " have children?(true or false)");
        boolean children = scanner.nextBoolean();
        if (children) {
            sum -= (sum / 100 * 20);
        } else {
            sum -= (sum / 100 * 25);
        }
        return sum;
    }

    @Override
    public void printPayTax() {
        System.out.println("Including tax: " + name + " = " + Tax());
    }


    public int getSum() {
        return sum;
    }
}
