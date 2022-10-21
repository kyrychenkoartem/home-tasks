package com.artem.week5;


import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;


public class StudentRunner {

    public static void main(String[] args) {
        List<Student> personList = List.of(
                new Student("Ivan", "Ivanov", 1, List.of(1, 4, 5, 3, 2, 3, 4)),
                new Student("Petr", "Petrov", 2, List.of(2, 6)),
                new Student("Sveta", "Svetikova", 3, List.of(3, 5, 2, 1, 4, 5, 2)),
                new Student("Kate", "Ivanova", 4, List.of(5, 2, 1, 3, 5, 6, 3)),
                new Student("Daniel", "Slavikov", 5, List.of(2, 4, 3, 5, 6, 2, 1)),
                new Student("Vasiliy", "Vasiliev", 6, List.of(1, 5)),
                new Student("John", "Martovnikov", 1, List.of(3, 5, 6, 2, 1, 3, 2)),
                new Student("James", "Mason", 2, List.of(4, 5, 6, 2, 1, 2, 3)),
                new Student("Oliver", "Logan", 3, List.of(5, 6, 2, 3, 1, 5, 4)),
                new Student("Benjamin", "Wyatt", 4, List.of(5, 4)),
                new Student("Daniel", "Carter", 5, List.of(3, 5, 6, 1, 2, 3, 4, 1)),
                new Student("Owen", "Lincoln", 6, List.of(4, 2, 3, 6, 1, 5, 2, 3))
        );

        Map<Integer, Double> filteredMap = personList.stream()
                .filter(student -> student.marks().size() > 3)
                .collect(groupingBy(Student::courseNumber,
                        mapping(student -> student.marks().stream().mapToInt(Integer::intValue).average(),
                                averagingDouble(OptionalDouble::getAsDouble))));
        System.out.println(filteredMap);

        Map<Integer, List<String>> sortedMap = personList.stream()
                .sorted(comparing(Student::firstName).thenComparing(Student::lastName))
                .collect(groupingBy(Student::courseNumber,
                        mapping(Student::getFullName, toList())));
        System.out.println(sortedMap);

        Map<Integer, Map<String, Double>> sortedMap2 = personList.stream()
                .sorted(comparing(Student::firstName).thenComparing(Student::lastName))
                .collect(groupingBy(Student::courseNumber,
                        groupingBy(Student::getFullName,
                                mapping(student -> student.marks().stream().mapToInt(Integer::intValue).average(),
                                        averagingDouble(OptionalDouble::getAsDouble)))));
        System.out.println(sortedMap2);
    }
}
