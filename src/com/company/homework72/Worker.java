package com.company.homework72;

public abstract class Worker implements Tax {

    public int rate(int payWork, int timeWork) {
        return payWork * timeWork;
    }

    public int hourPay(int payWork, int timeWork) {
        return payWork * timeWork;
    }

    public int deal(int payWork, int timeWork) {
        return payWork * timeWork;
    }
}
