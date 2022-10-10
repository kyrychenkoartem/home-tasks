package com.artem.week3.space;

public class MinorPlanet extends CelestialBody {

    private final long mass;

    private final String name;

    private final long radius;

    public MinorPlanet(long mass, String name, long radius) {
        this.mass = mass;
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "MinorPlanet{" +
                "mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
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
}