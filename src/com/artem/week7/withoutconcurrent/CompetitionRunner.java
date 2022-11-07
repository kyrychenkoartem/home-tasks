package com.artem.week7.withoutconcurrent;


import com.artem.week7.withoutconcurrent.model.Mage;
import com.artem.week7.withoutconcurrent.model.Planet;
import com.artem.week7.withoutconcurrent.thread.CrystalFactory;
import com.artem.week7.withoutconcurrent.thread.Day;
import com.artem.week7.withoutconcurrent.thread.Rocket;
import com.artem.week7.withoutconcurrent.util.ThreadUtil;

public class CompetitionRunner {

    public static void main(String[] args) throws InterruptedException {
        Day day = new Day();
        CrystalFactory crystalFactory = new CrystalFactory(new Planet(), day);
        Rocket airRocket = new Rocket(crystalFactory.getPlanet(), new Mage("Air"), day);
        Rocket fireRocket = new Rocket(crystalFactory.getPlanet(), new Mage("Fire"), day);

        ThreadUtil.startThreads(day, crystalFactory, airRocket, fireRocket);
        ThreadUtil.joinThreads(day, crystalFactory, airRocket, fireRocket);
        ThreadUtil.viewStatistic(airRocket.getMage(), fireRocket.getMage());
    }
}
