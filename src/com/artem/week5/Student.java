package com.artem.week5;

import java.util.List;

public record Student(String firstName, String lastName, int courseNumber, List<Integer> marks) {

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseNumber=" + courseNumber +
                ", marks=" + marks +
                '}';
    }
}