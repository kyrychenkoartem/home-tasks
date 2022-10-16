package com.artem.week3.space;


public class Comet extends CelestialBody implements WithLuminousTail {

    private final int gases;

    public Comet(int gases, long mass, String name, long radius) {
        super(mass, name, radius);
        this.gases = gases;
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

    @Override
    public String toString() {
        return "Comet{" +
                "gases=" + gases +
                ", mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }
}