package com.company;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        int sleep = 100;
//        Drop drop = new Drop();
        BlockingQueue<String> drop = new SynchronousQueue<>();
        (new Thread(new Producer(drop, sleep, 100))).start();
        (new Thread(new Consumer(drop, sleep))).start();
    }
}