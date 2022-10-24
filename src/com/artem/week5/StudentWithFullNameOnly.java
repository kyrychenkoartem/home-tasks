package com.artem.week5;

public record StudentWithFullNameOnly(String firstName, String lastName) {
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}