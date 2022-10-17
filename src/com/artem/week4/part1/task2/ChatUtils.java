package com.artem.week4.part1.task2;


import java.util.ArrayList;
import java.util.List;

public final class ChatUtils {

    private static final int TARGET_AGE = 18;

    private ChatUtils() {
    }

    public static List<User> convertToListUsers(List<Chat> chatList) {
        List<User> users = new ArrayList<>();
        for (Chat next : chatList) {
            for (User user : next.getUsers()) {
                if (user.getAge() > TARGET_AGE) {
                    users.add(user);
                }
            }
        }
        return users;
    }

    public static double countAverageAgeOfRemainingUsers(List<User> users, List<Chat> chatList) {
        double averageAge = 0;
        int countOfUsers = 0;
        ArrayList<User> remainingUsers = new ArrayList<>();
        for (Chat chat : chatList) {
            remainingUsers.addAll(chat.getUsers());
        }
        remainingUsers.removeAll(users);
        for (User next : remainingUsers) {
            averageAge += next.getAge();
            countOfUsers++;
        }
        return averageAge / countOfUsers;
    }
}