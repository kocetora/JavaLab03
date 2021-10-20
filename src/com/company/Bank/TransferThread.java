package com.company.Bank;

import java.util.concurrent.locks.ReentrantLock;

public class TransferThread extends Thread {
    private Bank bank;
    private int fromAccount;
    private int maxAmount;
    private static final int REPS = 1000;
    private ReentrantLock locker;

    public TransferThread(Bank b, int from, int max, ReentrantLock locker){
        bank = b;
        fromAccount = from;
        maxAmount = max;
        this.locker = locker;
    }
    @Override
    public void run(){
        while (true) {
//            synchronized (bank){
            for (int i = 0; i < REPS; i++) {
                locker.lock();
                int toAccount = (int) (bank.size() * Math.random());
                int amount = (int) (maxAmount * Math.random()/REPS);
                try {
                    bank.transfer(fromAccount, toAccount, amount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                locker.unlock();
            }
//            }
        }
    }
}