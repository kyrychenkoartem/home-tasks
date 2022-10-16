package com.artem.week3.space;

import java.util.Arrays;

public class Planet extends CelestialBody {

    private final Satellite[] satellites;

    public Planet(Satellite[] satellites, long mass, String name, long radius) {
        super(mass, name, radius);
        this.satellites = satellites;
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

    @Override
    public String toString() {
        return "Planet{" +
                "satellites=" + Arrays.toString(satellites) +
                ", mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }
}