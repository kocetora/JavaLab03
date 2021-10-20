package com.company.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
//    private Drop drop;
    private BlockingQueue<String> drop;
    private int sleep;
    private int[] numbers;

    public Producer(
//            Drop drop,
            BlockingQueue<String> drop,
            int sleep,
            int length) {
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
            try {
                drop.put("" + numbers[i]);
                Thread.sleep(random.nextInt(sleep));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            drop.put("DONE");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
