package com.artem.week4.part1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chatList = new ArrayList<>();
        chatList.add(new Chat("Slack", Arrays.asList(
                new User(1, "Ivan", 19),
                new User(2, "Artem", 20),
                new User(3, "Sveta", 18))
        ));
        chatList.add(new Chat("Telegram", Arrays.asList(
                new User(4, "Sergei", 15),
                new User(5, "Denis", 20),
                new User(6, "Alex", 17),
                new User(7, "John", 19))
        ));
        chatList.add(new Chat("Messenger", Arrays.asList(
                new User(8, "Anatoliy", 24),
                new User(9, "Tom", 16),
                new User(10, "Max", 17),
                new User(11, "Alina", 28),
                new User(12, "Rita", 13))
        ));
        System.out.println(chatList);
        List<User> users = ChatUtils.convertToListUsers(chatList);
        System.out.println(users);
        double averageAge = ChatUtils.countAverageAgeOfRemainingUsers(users, chatList);
        System.out.println("Average age of remaining users is: " + averageAge + " years");
    }
}