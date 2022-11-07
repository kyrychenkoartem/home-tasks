package com.artem.week7.withoutconcurrent.thread;

import com.artem.week7.withoutconcurrent.model.CrystalType;
import com.artem.week7.withoutconcurrent.model.Mage;
import com.artem.week7.withoutconcurrent.model.Planet;
import com.artem.week7.withoutconcurrent.util.RandomUtil;
import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread {

    private final Planet planet;
    private final Mage mage;
    private final Day day;

    public Rocket(Planet planet, Mage mage, Day day) {
        this.planet = planet;
        this.mage = mage;
        this.day = day;
    }

    @Override
    public void run() {
        try {
            while (!Mage.hasWinner()) {
                List<CrystalType> crystals = gatherCrystalsFromPlanet();
                mage.addCrystals(crystals);
                mage.getCrystals().values().forEach(System.out::println);
                if (mage.isCrystalEnough()) {
                    System.out.println(mage.getName() + " mage - Won!!!!");
                }
                waitNextDay();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Mage getMage() {
        return mage;
    }

    private List<CrystalType> gatherCrystalsFromPlanet() {
        int amountOfCrystals = RandomUtil.getAmountOfCrystals();
        List<CrystalType> gatheredCrystals = new ArrayList<>(RandomUtil.getNext(amountOfCrystals));
        synchronized (planet.getLock()) {
            if (planet.size() <= amountOfCrystals) {
                gatheredCrystals.addAll(planet.removeAll());
            } else if (planet.isNotEmpty()) {
                for (int i = 0; i < amountOfCrystals; i++) {
                    CrystalType removedCrystal = planet.remove(RandomUtil.getNext(planet.size()));
                    gatheredCrystals.add(removedCrystal);
                }
            }
            System.out.printf("%s mage gathered next crystals: %s\n", mage.getName(), gatheredCrystals);
        }
        return gatheredCrystals;
    }

    private void waitNextDay() throws InterruptedException {
        synchronized (day.getLock()) {
            day.getLock().wait();
        }
    }
}
