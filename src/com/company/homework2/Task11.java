package com.company.homework2;

public class Task11 {

    public static void main(String[] args) {

        int seconds = 1499599;

        int secondMinute = 60;
        int secondHour = secondMinute * 60;
        int secondDays = secondHour * 24;

        int resultDays = seconds / secondDays;
        int resultHour = seconds & secondDays / secondHour;
        int resultMinute = seconds & secondDays & secondHour / secondMinute;
        int resultSecond = seconds & secondDays & secondHour & secondMinute;

        System.out.println( resultDays + " дней, " + resultHour + " часов, " + resultMinute + " минут, " + resultSecond + " секунд");

    }
}
