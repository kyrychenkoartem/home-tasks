package com.artem.week2.oop;

public class Apartment {

    private static final String CONSOLE_PRINT_TEMPLATE = "Apartment number: is %d, number of bedrooms: are %d.";

    private final int number;

    private final Bedroom[] bedrooms;

    public Apartment(int number, Bedroom[] bedrooms) {
        this.number = number;
        this.bedrooms = bedrooms;
    }

    public Bedroom[] getBedrooms() {
        return bedrooms;
    }

    public int getNumber() {
        return number;
    }

    void print() {
        System.out.printf(CONSOLE_PRINT_TEMPLATE, getNumber(), getBedrooms().length);
        System.out.println();
        for (int i = 0, counter = 1; i < getBedrooms().length; i++, counter++) {
            getBedrooms()[i].print(counter);
            System.out.println();
        }
    }
}