package com.artem.week3.space;

import static java.lang.Math.PI;

public abstract class CelestialBody {

    protected final long mass;
    protected final String name;
    protected final long radius;

    protected CelestialBody(long mass, String name, long radius) {
        this.mass = mass;
        this.name = name;
        this.radius = radius;
    }

    public abstract long getMass();

    public abstract String getName();

    public abstract long getRadius();

    public double getVolume() {
        return (double) 4 / 3 * PI * Math.pow(getRadius(), 3);
    }

    public boolean isVolumeEqual(CelestialBody body) {
        return getVolume() == body.getVolume();
    }
}
