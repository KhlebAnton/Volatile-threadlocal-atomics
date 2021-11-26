package com.company.task2;

import java.util.stream.IntStream;

public class Shop {

    private static final int MAX_VALUE = 100;
    private static final int NUMBER = 5;

    private final int[] window = new int[NUMBER];
    private final String name;

    public Shop(String name) {
        this.name = name;
    }


    public long countMoney() {
        randomArray(window);
        System.out.printf("%s считает выручку\n", getName());
        long result = IntStream.of(window).sum();
        System.out.printf("Теперь у %s %d тыс. рублей\n", getName(), result);
        return result;
    }

    public void randomArray(int[] array) {
        for (int i = 0; i < NUMBER; i++) {
            array[i] = (int) Math.round((Math.random() * MAX_VALUE));
        }
    }

    public String getName() {
        return name;
    }
}