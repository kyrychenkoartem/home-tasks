package com.artem.week3.space;

public class SpaceRunner {

    public static void main(String[] args) {
        Comet comet1 = new Comet(100, 10000L, "Halley’s Comet", 8L);
        Comet comet2 = new Comet(50, 20000L, "Shoemaker Levy-9", 3L);
        Comet comet3 = new Comet(20, 5000L, "Comet Wild 2", 2L);
        Comet[] comets = {comet1, comet2, comet3};
        MinorPlanet minorPlanet1 = new MinorPlanet(939000000000L, "Ceres", 463L);
        MinorPlanet minorPlanet2 = new MinorPlanet(13000000000000L, "Pluto", 1188L);
        MinorPlanet minorPlanet3 = new MinorPlanet(4000000000000L, "Haumea", 816L);
        MinorPlanet[] minorPlanets = {minorPlanet1, minorPlanet2, minorPlanet3};
        Satellite satellite1 = new Satellite(734770000000L, "Luna", 1737L);
        Satellite satellite2 = new Satellite(14800000000L, "Deimos", 6L);
        Satellite satellite3 = new Satellite(107200000000L, "Fobos", 11L);
        Planet planet1 = new Planet(new Satellite[]{satellite1}, 597260000000000L, "Earth", 6356L);
        Planet planet2 = new Planet(new Satellite[]{satellite2, satellite3}, 64171000000000L, "Mars", 3396L);
        Planet[] planets = {planet1, planet2};
        Star star1 = new Star(2500000000000000000L, "VV Cefei A", 1900L, 200000L);
        Star star2 = new Star(4000000000000000000L, "VY Canis Majoris", 4000L, 1000000L);
        Star[] stars = {star1, star2};
        Galaxy milky_way = new Galaxy(
                GalaxyShapeType.ELLIPTICAL,
                comets,
                minorPlanets,
                planets,
                stars,
                1200000000000000000L,
                "Milky Way",
                50000);
        System.out.println(milky_way);
    }
}
