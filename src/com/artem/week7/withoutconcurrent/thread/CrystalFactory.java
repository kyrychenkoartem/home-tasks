package com.artem.week7.withoutconcurrent.thread;

import com.artem.week7.withoutconcurrent.model.CrystalType;
import com.artem.week7.withoutconcurrent.model.Planet;
import com.artem.week7.withoutconcurrent.util.RandomUtil;
import com.artem.week7.withoutconcurrent.util.ThreadUtil;

public class CrystalFactory extends Thread {

    private final Planet planet;
    private final Day day;

    public CrystalFactory(Planet planet, Day day) {
        this.planet = planet;
        this.day = day;
    }

    @Override
    public void run() {
        try {
            while (!ThreadUtil.isInterruptNecessary.get()) {
                growNewCrystals();
                waitNextDay();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Planet getPlanet() {
        return planet;
    }

    private void growNewCrystals() throws InterruptedException {
        int amountOfCrystals = RandomUtil.getAmountOfCrystals();
        synchronized (planet.getLock()) {
            for (int i = 0; i < amountOfCrystals; i++) {
                CrystalType crystal = RandomUtil.getNextCrystal();
                planet.add(crystal);
            }
            System.out.println("New crystals have grown on the planet. Amount: " + amountOfCrystals);
        }
    }

    private void waitNextDay() throws InterruptedException {
        synchronized (day.getLock()) {
            day.getLock().wait();
        }
    }
}
