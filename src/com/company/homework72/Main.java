package com.company.homework72;

public class Main {

    public static void main(String[] args) {

        Rate rate = new Rate("Ivan");
        rate.rate(1500, 22);
        System.out.println(rate);
        HourPay hourPay = new HourPay("Pavel");
        hourPay.hourPay(150, 160);
        System.out.println(hourPay);
        Deal deal = new Deal("Maxim");
        deal.deal(5000, 8);
        System.out.println(deal);
        System.out.println("Total " + (rate.getSum() + hourPay.getSum() + deal.getSum()));
        rate.printPayTax();
        hourPay.printPayTax();
        deal.printPayTax();
        System.out.println("Total " + (rate.getSum() + hourPay.getSum() + deal.getSum()));
    }
}
