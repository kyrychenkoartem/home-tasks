package com.artem.week5;

import java.util.List;

public record Statistics(List<StudentWithFullNameOnly> studentList, double averageMark) {
    @Override
    public String toString() {
        return "StudentList=" + studentList +
                ", averageMark=" + averageMark +
                '}';
    }
}