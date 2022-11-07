package com.artem.week7.withoutconcurrent.util;

import com.artem.week7.withoutconcurrent.model.Mage;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ThreadUtil {

    public static AtomicBoolean isInterruptNecessary = new AtomicBoolean(false);

    private ThreadUtil() {
    }

    public static void startThreads(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void joinThreads(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void viewStatistic(Mage firstMage, Mage secondMage) {
        System.out.println("----------------");
        System.out.println(firstMage.getName() + " " + firstMage.getCrystals());
        System.out.println(secondMage.getName() + " " + secondMage.getCrystals());
    }
}

