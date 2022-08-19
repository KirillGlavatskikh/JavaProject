package com.company.homeworkMultithreading;

public class Main {

    public static void main(String[] args) {

        Philosopher philosoph = new Philosopher();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(philosoph);
            thread.start();
        }
    }
}
