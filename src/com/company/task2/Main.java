package com.company.task2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder stat = new LongAdder();

        Shop shop1 = new Shop("Пятерочка");
        Shop shop2 = new Shop("Карусель");
        Shop shop3 = new Shop("Перекресток");

        ThreadGroup mainGroup = new ThreadGroup("main group");
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(mainGroup,Thread.currentThread());
            thread.start();
        }

        mainGroup.interrupt();

        executorService.submit(() -> stat.add(shop1.countMoney()));
        executorService.submit(() -> stat.add(shop2.countMoney()));
        executorService.submit(() -> stat.add(shop3.countMoney()));
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("\nРезультат: " + stat.sum() + " тыс. рублей");
        executorService.shutdown();
    }
}
