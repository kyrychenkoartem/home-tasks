package com.artem.week3.space;

public class Satellite extends CelestialBody {

    private final long mass;

    private final String name;

    private final long radius;

    public Satellite(long mass, String name, long radius) {
        this.mass = mass;
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }

    public long getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    @Override
    public long getRadius() {
        return radius;
    }
}