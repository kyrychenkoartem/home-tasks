package com.artem.week7.withoutconcurrent.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Mage {

    private static final int NECESSARY_AMOUNT_OF_CRYSTALS = 500;
    private final Map<CrystalType, Integer> crystals = new EnumMap<>(CrystalType.class);
    private final String name;
    private static boolean IS_WINNER = false;

    public Mage(String name) {
        this.name = name;
        crystals.put(CrystalType.RED, 0);
        crystals.put(CrystalType.WHITE, 0);
    }

    public void addCrystals(List<CrystalType> crystalList) {
        crystalList.forEach(crystal -> crystals.merge(crystal, 1, Integer::sum));
        if (isCrystalEnough()) {
            IS_WINNER = true;
        }
    }

    public boolean isCrystalEnough() {
        return crystals.get(CrystalType.RED) >= NECESSARY_AMOUNT_OF_CRYSTALS
                && crystals.get(CrystalType.WHITE) >= NECESSARY_AMOUNT_OF_CRYSTALS;
    }

    public static boolean hasWinner() {
        return IS_WINNER;
    }

    public String getName() {
        return name;
    }

    public Map<CrystalType, Integer> getCrystals() {
        return crystals;
    }
}
