package com.artem.week3.space;

import java.util.Arrays;

public class Galaxy extends CelestialBody {

    private final GalaxyShapeType shapeType;

    private final Comet[] comets;

    private final MinorPlanet[] minorPlanets;

    private final Planet[] planets;

    private final Star[] stars;

    private final long mass;

    private final String name;

    private final long radius;

    public Galaxy(GalaxyShapeType shapeType, Comet[] comets, MinorPlanet[] minorPlanets,
                  Planet[] planets, Star[] stars, long mass, String name, long radius) {
        this.shapeType = shapeType;
        this.comets = comets;
        this.minorPlanets = minorPlanets;
        this.planets = planets;
        this.stars = stars;
        this.mass = mass;
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Galaxy{" +
                "shapeType=" + shapeType +
                ", comets=" + Arrays.toString(comets) +
                ", minorPlanets=" + Arrays.toString(minorPlanets) +
                ", planets=" + Arrays.toString(planets) +
                ", stars=" + Arrays.toString(stars) +
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
}
