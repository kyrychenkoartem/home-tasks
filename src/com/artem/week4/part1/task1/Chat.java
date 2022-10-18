package com.artem.week4.part1.task1;

public record Chat(String name, int numberOfUsers) implements Comparable<Chat> {

    @Override
    public int compareTo(Chat o) {
        return name.compareTo(o.name());
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }
}
