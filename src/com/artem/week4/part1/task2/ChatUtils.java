package com.artem.week4.part1.task2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ChatUtils {

    private static final int TARGET_AGE = 18;

    private ChatUtils() {
    }

    public static List<User> convertToListUsers(List<Chat> chatList) {
        List<User> users = new ArrayList<>();
        for (Chat next : chatList) {
            users.addAll(next.users());
        }
        return users;
    }

    public static List<User> filterByAge(List<User> users) {
        List<User> result = new ArrayList<>();
        for (User next : users) {
            if (next.age() > 18) {
                result.add(next);
            }
        }
        return result;
    }

    public static double countAverageAgeOfRemainingUsers(List<User> users, List<Chat> chatList) {
        double averageAge = 0;
        ArrayList<User> remainingUsers = new ArrayList<>();
        for (Chat chat : chatList) {
            remainingUsers.addAll(chat.users());
        }
        remainingUsers.removeAll(users);
        for (User next : remainingUsers) {
            averageAge += next.age();
        }
        int countOfUsers = remainingUsers.size();
        return averageAge / countOfUsers;
    }

    public static double calculateAverageUsersAge(List<User> users) {
        double sumOfUserAges = 0.0;
        int numberOfUsers = users.size();
        Iterator<User> iterator = users.listIterator();
        while (iterator.hasNext()) {
            sumOfUserAges += iterator.next().age();
        }
        return sumOfUserAges / numberOfUsers;
    }
}