package com.company;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;
    private int sleep;
    private int[] numbers;

    public Producer(Drop drop, int sleep, int length) {
        this.drop = drop;
        this.sleep = sleep;
        this.numbers = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            this.numbers[i] = i;
        }
    }

    public void run() {
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            drop.put(numbers[i]);
            try {
                Thread.sleep(random.nextInt(sleep));
            } catch (InterruptedException e) {}
        }
        drop.put(-1);
    }
}
