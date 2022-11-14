package com.artem.week8.dto;

public enum ComplaintType {
    INTERNET_SLOW_SPEED_PROBLEM("Extremely slow internet connection"),
    LIGHT_PROBLEM("Light does not turn on"),
    CABLE_PROBLEM("Someone cut my telephone cable"),
    INTERNET_WORK_PROBLEM("Why is the internet not working again?"),
    SPAM_PROBLEM("Why do i get a lot of spam messages?"),
    WRONG_NUMBER_PROBLEM("Someone made a call from my number");

    private final String name;

    ComplaintType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
