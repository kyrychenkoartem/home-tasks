package com.artem.week5;

import java.util.List;

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

        System.out.println(Student.filteredMap(personList));
        System.out.println(Student.sortedMap(personList));
        System.out.println(Student.sortedMap2(personList));
    }
}