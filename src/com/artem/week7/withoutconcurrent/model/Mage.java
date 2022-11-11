package com.artem.week7.withoutconcurrent.model;

import com.artem.week7.withoutconcurrent.util.ThreadUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Mage {

    private static final int NECESSARY_AMOUNT_OF_CRYSTALS = 500;
    private final ConcurrentMap<CrystalType, Integer> crystals = new ConcurrentHashMap<>();
    private final String name;

    public Mage(String name) {
        this.name = name;
        crystals.put(CrystalType.RED, 0);
        crystals.put(CrystalType.WHITE, 0);
    }

    public void addCrystals(List<CrystalType> crystalList) {
        crystalList.forEach(crystal -> crystals.merge(crystal, 1, Integer::sum));
        isInterruptNecessary();
    }

    public boolean isCrystalEnough() {
        return crystals.get(CrystalType.RED) >= NECESSARY_AMOUNT_OF_CRYSTALS
                && crystals.get(CrystalType.WHITE) >= NECESSARY_AMOUNT_OF_CRYSTALS;
    }

    public String getName() {
        return name;
    }

    public Map<CrystalType, Integer> getCrystals() {
        return crystals;
    }

    private void isInterruptNecessary() {
        if (isCrystalEnough()) {
            ThreadUtil.isInterruptNecessary.set(true);
        }
    }
}
