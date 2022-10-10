package com.artem.week3.space;

import static java.lang.Math.*;

public class Star extends CelestialBody implements WithLightEmission {

    public static final int COS = (int) (random() * 90);

    private final long mass;

    private final String name;

    private final long radius;

    private final long lightFlow;

    public Star(long mass, String name, long radius, long lightFlow) {
        this.mass = mass;
        this.name = name;
        this.radius = radius;
        this.lightFlow = lightFlow;
    }

    @Override
    public String toString() {
        return "Star{" +
                "mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                ", lightFlow=" + lightFlow +
                '}';
    }

    public long getLightFlow() {
        return lightFlow;
    }

    @Override
    public long getMass() {
        return mass;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getRadius() {
        return radius;
    }

    @Override
    public double lightEmission() {
        return getLightFlow() * cos(COS);
    }
}
