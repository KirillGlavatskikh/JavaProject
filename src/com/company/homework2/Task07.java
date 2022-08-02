package com.company.homework2;

public class Task07 {

    public static void main(String[] args) {

        double p = 350000;  //Сумма вклада
        double i = 6;       //Процентная ставка
        double t = 730;     //Количество дней вклада
        double k = 365;     //Дней в году

        double sum = (p * i * t / k) / 100;

        System.out.println("Сумма вклада в банке через два года: " + (sum + p));

    }
}
