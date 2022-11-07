package com.artem.week7.withoutconcurrent.thread;

import com.artem.week7.withoutconcurrent.model.Mage;
import com.artem.week7.withoutconcurrent.util.RandomUtil;

public class Day extends Thread {

    private final Object lock = new Object();

    @Override
    public void run() {
        while (!Mage.hasWinner()) {
            synchronized (lock) {
                try {
                    System.out.println("----------------\nDay started, new crystals have grown");
                    lock.notifyAll();
                    lock.wait(RandomUtil.WAITING_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }

}