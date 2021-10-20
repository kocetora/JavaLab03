package com.company.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
//    private Drop drop;
    private BlockingQueue<String> drop;
    private int sleep;

    public Consumer(
//            Drop drop,
            BlockingQueue<String> drop,
            int sleep) {
        this.drop = drop;
        this.sleep = sleep;
    }

    public void run() {
        Random random = new Random();
        try {
            for (
                    String message = drop.take();
                    !message.equals("DONE");
                    message = drop.take()) {
                System.out.format("MESSAGE RECEIVED: %s%n", message);
                try {
                    Thread.sleep(random.nextInt(sleep));
                } catch (InterruptedException e) {}
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}