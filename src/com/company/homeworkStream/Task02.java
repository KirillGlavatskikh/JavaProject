package com.company.homeworkStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task02 {
    //Практические задания 2
    //? Показать все телевизоры, отсортированные по диагонали по возрастанию;
    //? Показать все телевизоры, отсортированные по диагонали по убыванию.”

    public static void main(String[] args) {

        List<Television> tvList = new ArrayList<>();
        initList(tvList);

        tvList.stream()
                .sorted(Comparator.comparing(Television::getDiagonal))
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        tvList.stream()
                .sorted(Comparator.comparing(Television::getDiagonal).reversed())
                .forEach(System.out::println);
    }

    private static void initList(List<Television> tvList) {
        tvList.add(new Television("LG", 2015L, 20000L, 55L, "Korea"));
        tvList.add(new Television("Samsung", 2022L, 100000L, 100L, "Korea"));
        tvList.add(new Television("Philips", 2020L, 50000L, 70L, "Netherlands"));
        tvList.add(new Television("Sony", 2017L, 40000L, 85L, "Japan"));
        tvList.add(new Television("Xiaomi", 2019L, 30000L, 70L, "China"));
    }
}
