package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Toy toy = new Toy();
        User user1 = new User(toy);
        User user2 = new User(toy);

        Thread threadUser1 = new Thread(null, () -> {
            try {
                user1.turnOn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Игрушка");

        Thread threadUser2 = new Thread(null, () -> {
            try {
                user2.turnOff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Пользователь");

        threadUser1.start();
        threadUser2.start();

        Thread.sleep(20000);

        threadUser1.interrupt();
        threadUser2.interrupt();

    }
}