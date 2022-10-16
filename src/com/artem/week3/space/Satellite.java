package com.artem.week3.space;

public class Satellite extends CelestialBody {

    public Satellite(long mass, String name, long radius) {
        super(mass, name, radius);
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

    @Override
    public String toString() {
        return "Satellite{" +
                "mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }
}