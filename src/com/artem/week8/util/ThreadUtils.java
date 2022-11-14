package com.artem.week8.util;

public final class ThreadUtils {

    private ThreadUtils() {
    }

    public static void execute(Runnable... runnable) {
        for (Runnable runnable1 : runnable) {
            Thread thread = new Thread(runnable1);
            thread.start();
        }
    }
}
