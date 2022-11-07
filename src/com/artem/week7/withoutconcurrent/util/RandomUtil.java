package com.artem.week7.withoutconcurrent.util;

import com.artem.week7.withoutconcurrent.model.CrystalType;
import java.util.Random;

public final class RandomUtil {

    public static final int WAITING_TIME = 50;
    private static final int MIN_CRYSTAL_COUNT = 2;
    private static final int MAX_CRYSTAL_COUNT = 5;
    private static final int WHITE_CRYSTAL = 1;

    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getAmountOfCrystals() {
        return MIN_CRYSTAL_COUNT + RANDOM.nextInt(MAX_CRYSTAL_COUNT - MIN_CRYSTAL_COUNT + 1);
    }

    public static CrystalType getNextCrystal() {
        int numberOfCrystal = RANDOM.nextInt(WHITE_CRYSTAL + 1);
        return CrystalType.CASHED_VALUES.get(numberOfCrystal);
    }

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }
}