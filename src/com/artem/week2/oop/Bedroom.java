package com.artem.week2.oop;

public class Bedroom {

    private static final String CONSOLE_PRINT_TEMPLATE = "Bedroom %d: is %s.";
    private static final String WALK_THROUGH = "walk-through";
    private static final String NO_WALK_THROUGH = "not walk-through";

    private final boolean isWalkThrough;

    public Bedroom(boolean isWalkThrough) {
        this.isWalkThrough = isWalkThrough;
    }

    public boolean isWalkThrough() {
        return isWalkThrough;
    }

    void print(int counter) {
        if (isWalkThrough()) {
            System.out.printf(CONSOLE_PRINT_TEMPLATE, counter, WALK_THROUGH);
        } else {
            System.out.printf(CONSOLE_PRINT_TEMPLATE, counter, NO_WALK_THROUGH);
        }
    }
}