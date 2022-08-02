package com.company.lambda;


public class Task04 {

    //Задание 4 Создайте и вызовите следующие лямбда-выражения.
    //Обязательно использовать лямбду, как параметр метода.
    //Метод находит сумму элементов массива, которые соответствуют условию лямбда-выражения.
    //Варианты лямбда-выражений:
    //Проверка на четность;
    //Проверка на нечетность;
    //Число находится в диапазоне от A до B;
    //Проверка на кратность параметру A

    public static void main(String[] args) {

        Double[] array = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};

        Condition conditionEven = x -> x % 2 == 0;
        double sumEvenNumbers = sum(array, conditionEven);
        System.out.println(sumEvenNumbers);

        Condition conditionNotEven = x -> x % 2 != 0;
        double sumNotEvenNumbers = sum(array, conditionNotEven);
        System.out.println(sumNotEvenNumbers);

        ConditionByInterval conditionByInterval = (number, start, end) -> number > start && number < end;
        System.out.println(conditionByInterval.isCondition(4.0,2.0,5.0));

        Multiple multiple = (x, y) -> x % y == 0;
        System.out.println(multiple.isMultiple(6.0, 2.0));
    }

    public static double sum(Double[] array, Condition condition) {
        double sum = 0;
        for (Double aDouble : array) {
            if (condition.isCondition(aDouble)) {
                sum += aDouble;
            }
        }
        return sum;
    }

    @FunctionalInterface
    public interface Condition {
        boolean isCondition(Double number);
    }

    @FunctionalInterface
    public interface ConditionByInterval {
        boolean isCondition(Double number, Double start, Double end);
    }
    @FunctionalInterface
    public  interface Multiple {
        boolean isMultiple (Double number, double divider);
    }
}

