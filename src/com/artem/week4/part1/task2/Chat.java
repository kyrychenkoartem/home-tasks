package com.artem.week4.part1.task2;

import java.util.List;

public record Chat(String name, List<User> users) {

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}