package com.artem.week3.space;

public class MinorPlanet extends CelestialBody {

    public MinorPlanet(long mass, String name, long radius) {
        super(mass, name, radius);
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
        return "MinorPlanet{" +
                "mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }
}