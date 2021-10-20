package com.company;

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;
    private int sleep;

    public Consumer(Drop drop, int sleep) {
        this.drop = drop;
        this.sleep = sleep;
    }

    public void run() {
        Random random = new Random();
        for (int message = drop.take();
             message != -1;
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(sleep));
            } catch (InterruptedException e) {}
        }
    }
}