package com.company.homeworkMultithreading;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

    Semaphore semaphore = new Semaphore(3);
    Random random = new Random();
    private static int fork = 5;

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Philosoph " + Thread.currentThread().getName() + " sit down at the table, took the fork, thinks");
            fork--;
            Thread.sleep(random.nextInt(2000) + 1000);
            if (fork > 0) {
                System.out.println("Philosoph " + Thread.currentThread().getName() + " take a seconds fork. Eats");
                fork--;
                Thread.sleep(random.nextInt(2000) + 1000);
            } else {
                System.out.println("Pholosoph " + Thread.currentThread().getName() + " No forks");
                Thread.sleep(random.nextInt(2000) + 1000);
                if (fork > 0) {
                    System.out.println("Philosoph " + Thread.currentThread().getName() + " take a seconds fork. Eats");
                    fork--;
                    Thread.sleep(random.nextInt(2000) + 1000);
                }
            }
            System.out.println("Philosoph " + Thread.currentThread().getName() + " ate and put down both forks");
            fork = fork + 2;
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(fork);
    }
}
