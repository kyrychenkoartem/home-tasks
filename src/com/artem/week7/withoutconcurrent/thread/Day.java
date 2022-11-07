package com.artem.week7.withoutconcurrent.thread;

import com.artem.week7.withoutconcurrent.util.RandomUtil;

public class Day extends Thread {

    private final Object lock = new Object();

    private volatile boolean isEnough = false;

    @Override
    public void run() {
        synchronized (lock) {
            try {
                while (!isEnough()) {
                    System.out.println("----------------\nDay started, new crystals have grown");
                    lock.notifyAll();
                    if (isEnough()) {
                        break;
                    }
                    lock.wait(RandomUtil.WAITING_TIME);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void setEnough(boolean enough) {
        isEnough = enough;
    }

    public boolean isEnough() {
        return isEnough;
    }

    public Object getLock() {
        return lock;
    }

}
