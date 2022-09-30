package com.artem.week2.oop;

public class Floor {

    private static final String CONSOLE_PRINT_TEMPLATE = "Floor number: is %d, number of apartments: are %d.";

    private int number;

    private Apartment[] apartments;

    public Floor(int number, Apartment[] apartments) {
        this.number = number;
        this.apartments = apartments;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public int getNumber() {
        return number;
    }

    void print() {
        System.out.printf(CONSOLE_PRINT_TEMPLATE, getNumber(), getApartments().length);
        System.out.println();
        for (int i = 0; i < getApartments().length; i++) {
            getApartments()[i].print();
        }
    }
}
