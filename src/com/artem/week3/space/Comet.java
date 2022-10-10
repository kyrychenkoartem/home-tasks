package com.artem.week3.space;


public class Comet extends CelestialBody implements WithLuminousTail {

    private final int gases;

    private final long mass;

    private final String name;

    private final long radius;

    public Comet(int gases, long mass, String name, long radius) {
        this.gases = gases;
        this.mass = mass;
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Comet{" +
                "gases=" + gases +
                ", mass=" + mass +
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

    @Override
    public int gasVariability() {
        return gases;
    }
}