package com.artem.week7.withoutconcurrent.model;

import java.util.Arrays;
import java.util.List;

public enum CrystalType {
    RED,
    WHITE;

    public static final List<CrystalType> CASHED_VALUES = Arrays.asList(values());
}
