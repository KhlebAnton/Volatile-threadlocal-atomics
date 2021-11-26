package com.company;

public class Toy {

    private static final int TIME = 4000;
    private volatile boolean TUMBLER = false;

    public Toy() {
    }

    public boolean isTUMBLER() {
        return TUMBLER;
    }


    public void turnOnTumbler() throws InterruptedException {
        System.out.println("*Тумблер игрушки: " + TUMBLER + " -");
        Thread.sleep(TIME);
        System.out.printf("%s: включил тумблер!\n", Thread.currentThread().getName());
        TUMBLER = true;
    }

    public void turnOffTumbler() throws InterruptedException {
        System.out.println("*Тумблер игрушки: " + TUMBLER + " +");
        Thread.sleep(TIME);
        System.out.printf("%s: возвращаю обратно!\n", Thread.currentThread().getName());
        TUMBLER = false;
    }
}