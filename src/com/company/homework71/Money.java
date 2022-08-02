package com.company.homework71;

public class Money {
    public static void main(String[] args) {
        moneyOperation money = new moneyOperation(15L, (byte) 120);
        money.additionOperation();
        money.subtractionOperation();
        money.divisionOperation();
        money.multiplicationOperation();
    }
}

class moneyOperation {
    private long rubles;
    private byte penny;


    public moneyOperation(long rubles, byte penny) {
        this.rubles = rubles;
        this.penny = penny;

        System.out.println("На счету: " + rubles + "," + penny);
    }

    public void additionOperation() {
        if (penny >= 100) {
            long correctRub = penny / 100 + rubles;
            byte correctPenny = (byte) (penny % 100);
            System.out.println("Корректная сумма (сложение): " + correctRub + "," + correctPenny);
        }
    }

    public void subtractionOperation() {
        if (rubles <= 1 && penny > 100) {
            System.out.println("Вычитание не возможно, у вас не хватает средств");
            return;
        }
        if (penny >= 100) {
            long correctRub = rubles - (penny / 100) - 1;
            byte correctPenny = (byte) (100 - penny % 100);
            System.out.println("Результат вычитания: " + correctRub + "," + correctPenny);
        } else {
            long correctRub = rubles - 1;
            byte correctPenny = (byte) (100 - penny);
            System.out.println("Результат вычитания: " + correctRub + "," + correctPenny);
        }
    }

    public void divisionOperation() {
        if (rubles <= 1 && penny > 100) {
            System.out.println("Деление не возможно, у вас не хватает средств");
        } else {
            long correctRub = rubles * 100 / penny;
            byte correctPenny = (byte) (rubles * 100 - (correctRub * penny));
            System.out.println("Результат деления: " + correctRub + " , на счету осталось " + correctPenny + " копеек");
        }
    }

    public void multiplicationOperation() {
        long correctRub = rubles * penny / 100;
        byte correctPenny = (byte) (rubles * penny % 100);
        System.out.println("Результат умножения: " + correctRub + "," + correctPenny);

    }
}
