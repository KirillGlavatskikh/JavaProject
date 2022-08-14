package com.company.homeworkStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task01 {

    //—оздайте класс “елевизор. ќн должен хранить информацию о названии модели, год выпуска, цена, диагональ, производитель.
    //Ќужно создать набор телевизоров и выполнить следующие задачи:
    //? ѕоказать все телевизоры;
    //? ѕоказать телевизоры с заданной диагональю;
    //? ѕоказать все телевизоры одного производител€;
    //? ѕоказать все телевизоры текущего года;
    //? ѕоказать все телевизоры дороже заданной цены;
    //? ѕоказать все телевизоры, отсортированные по цене по возрастанию;
    //? ѕоказать все телевизоры, отсортированные по цене по убыванию.

    public static void main(String[] args) {

        List<Television> tvList = new ArrayList<>();

        initList(tvList);
        tvList.forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------");

        List<Television> filterDiagonal = tvList.stream()
                .filter(television -> television.getDiagonal() == 70)
                .toList();
        System.out.println(filterDiagonal);

        System.out.println("------------------------------------------------------------------------------------------");

        List<Television> filterMadeIn = tvList.stream()
                .filter(television -> television.getMadeIn().equals("Korea"))
                .toList();
        System.out.println(filterMadeIn);

        System.out.println("------------------------------------------------------------------------------------------");

        List<Television> filterYearRelease = tvList.stream()
                .filter(television -> television.getYearRelease() == 2022)
                .toList();
        System.out.println(filterYearRelease);

        System.out.println("------------------------------------------------------------------------------------------");

        List<Television> filterPrice = tvList.stream()
                .filter(television -> television.getPrice() > 30000)
                .toList();
        System.out.println(filterPrice);

        System.out.println("------------------------------------------------------------------------------------------");

        List<Television> sortAscending = tvList.stream()
                .sorted(Comparator.comparing(Television::getPrice))
                .toList();
        System.out.println(sortAscending);

        System.out.println("------------------------------------------------------------------------------------------");

        List<Television> sortDescending = tvList.stream()
                .sorted(Comparator.comparing(Television::getPrice).reversed())
                .toList();
        System.out.println(sortDescending);
    }

    private static void initList(List<Television> tvList) {
        tvList.add(new Television("LG", 2015L, 20000L, 55L, "Korea"));
        tvList.add(new Television("Samsung", 2022L, 100000L, 100L, "Korea"));
        tvList.add(new Television("Philips", 2020L, 50000L, 70L, "Netherlands"));
        tvList.add(new Television("Sony", 2017L, 40000L, 85L, "Japan"));
        tvList.add(new Television("Xiaomi", 2019L, 30000L, 70L, "China"));
    }
}
