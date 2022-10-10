package com.artem.week3.space;

import java.util.Arrays;

public class Planet extends CelestialBody {

    private final Satellite[] satellites;

    private final long mass;

    private final String name;

    private final long radius;

    public Planet(Satellite[] satellites, long mass, String name, long radius) {
        this.satellites = satellites;
        this.mass = mass;
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "satellites=" + Arrays.toString(satellites) +
                ", mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }

    public Satellite[] getSatellites() {
        return satellites;
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