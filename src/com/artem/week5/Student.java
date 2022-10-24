package com.artem.week5;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public record Student(String firstName, String lastName, int courseNumber, List<Integer> marks) {

    public double averageMark() {
        return marks.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static Map<Integer, Double> filteredMap(List<Student> studentList) {
        return studentList.stream()
                .filter(student -> student.marks().size() > 3)
                .collect(groupingBy(Student::courseNumber, averagingDouble(Student::averageMark)));
    }

    public static Map<Integer, List<StudentWithFullNameOnly>> sortedMap(List<Student> studentList) {
        return studentList.stream()
                .sorted(comparing(Student::firstName).thenComparing(Student::lastName))
                .collect(groupingBy(Student::courseNumber,
                        mapping(student -> new StudentWithFullNameOnly(student.firstName(), student.lastName()), toList())));
    }

    public static Map<Integer, Statistics> sortedMap2(List<Student> studentList) {
        return studentList.stream()
                .sorted(comparing(Student::firstName).thenComparing(Student::lastName))
                .collect(groupingBy(Student::courseNumber,
                        collectingAndThen(toList(), students -> {
                            List<StudentWithFullNameOnly> studentSortedList = students.stream()
                                    .map(student -> new StudentWithFullNameOnly(student.firstName(), student.lastName()))
                                    .collect(toList());
                            Double averageMark = students.stream()
                                    .map(Student::averageMark)
                                    .collect(averagingDouble(Double::doubleValue));
                            return new Statistics(studentSortedList, averageMark);
                        })));
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