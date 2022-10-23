package com.artem.week5;

import java.util.List;

public record Student(String firstName, String lastName, int courseNumber, List<Integer> marks) {

    record Statistics(List<StudentWithFullNameOnly> studentList, double averageMark) {
        @Override
        public String toString() {
            return "StudentList=" + studentList +
                    ", averageMark=" + averageMark +
                    '}';
        }
    }

    record StudentWithFullNameOnly(String firstName, String lastName) {
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

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