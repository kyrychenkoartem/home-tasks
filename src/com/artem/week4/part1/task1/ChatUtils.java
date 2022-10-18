package com.artem.week4.part1.task1;

import java.util.List;
import java.util.ListIterator;

public final class ChatUtils {

    private static final int MINIMUM_USER_AGE = 1000;

    private ChatUtils() {
    }

    public static List<Chat> deleteChatsFromList(List<Chat> list) {
//        list.removeIf(next -> next.getNumberOfUsers() < TARGET_USERS);
        ListIterator<Chat> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Chat next = listIterator.next();
            if (next.numberOfUsers() < MINIMUM_USER_AGE) {
                listIterator.remove();
            }
        }
        return list;
    }
}
