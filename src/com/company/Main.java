package com.company;

import com.company.Bank.Bank;
import com.company.Bank.TransferThread;
import com.company.GradeBook.*;
import com.company.ProducerConsumer.Consumer;
import com.company.ProducerConsumer.Drop;
import com.company.ProducerConsumer.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception {
//        AsynchBankTest();
//        ProducerConsumerTest();
        GradeBookTest();
    }

    public static void AsynchBankTest(){
        final int NACCOUNTS = 10;
        final int INITIAL_BALANCE = 10000;

        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        ReentrantLock locker = new ReentrantLock();
        for (i = 0; i < NACCOUNTS; i++){
            TransferThread t = new TransferThread(b, i,
                    INITIAL_BALANCE, locker);
            t.setPriority(Thread.NORM_PRIORITY + i % 2);
            t.start () ;
        }
    }

    public static void ProducerConsumerTest() {
        int sleep = 100;
        BlockingQueue<String> drop = new SynchronousQueue<>();
        (new Thread(new Producer(drop, sleep, 100))).start();
        (new Thread(new Consumer(drop, sleep))).start();
    }

    public static void GradeBookTest() {
        int groups = 2;
        int studentsInGroup = 3;
        int weeks = 3;

        GradeBook gradeBook = new GradeBook(groups, studentsInGroup);

        for (int i = 0; i < groups; i++) {
            new AssistantThread(gradeBook, i, weeks).start();
        }
        new LecturerThread(gradeBook, weeks).start();
    }
}
