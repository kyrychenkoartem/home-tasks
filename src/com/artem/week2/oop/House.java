package com.artem.week2.oop;


public class House {

    private static final String CONSOLE_PRINT_TEMPLATE = "House number: is %d, number of floors: are %d.";

    private final int number;

    private final Floor[] floors;

    public House(int number, Floor[] floors) {
        this.number = number;
        this.floors = floors;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public int getNumber() {
        return number;
    }

    void print() {
        System.out.printf(CONSOLE_PRINT_TEMPLATE, getNumber(), getFloors().length);
        System.out.println();
        for (int i = 0; i < getFloors().length; i++) {
            getFloors()[i].print();
        }
    }
}