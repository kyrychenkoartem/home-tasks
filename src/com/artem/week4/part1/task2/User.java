package com.artem.week4.part1.task2;

public record User(int id, String name, int age) {

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}