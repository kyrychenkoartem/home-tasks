package com.artem.week4.part1.task1;

public class Chat implements Comparable<Chat> {

    private final String name;
    private final int numberOfUsers;

    public Chat(String name, int numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    @Override
    public int compareTo(Chat o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }
}
