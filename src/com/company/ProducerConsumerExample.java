package com.company;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        int sleep = 100;
        Drop drop = new Drop();
        (new Thread(new Producer(drop, sleep, 5000))).start();
        (new Thread(new Consumer(drop, sleep))).start();
    }
}