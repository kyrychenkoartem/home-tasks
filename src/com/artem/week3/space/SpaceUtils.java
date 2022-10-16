package com.artem.week3.space;

public final class SpaceUtils {

    private SpaceUtils() {
    }

    public static double getGravityPower(CelestialBody object1, CelestialBody object2) {
        return Math.abs((object1.getMass() * object1.getVolume()) / (object2.getMass() * object2.getVolume()));
    }

    public static boolean isStar(CelestialBody object) {
        return object instanceof Star;
    }
}