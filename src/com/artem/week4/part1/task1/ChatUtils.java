package com.artem.week4.part1.task1;

import java.util.ArrayList;
import java.util.List;

public final class ChatUtils {

    private static final int TARGET_USERS = 1000;

    private ChatUtils() {
    }

    public static List<Chat> deleteChatsFromList(List<Chat> list) {
        List<Chat> result = new ArrayList<>();
        for (Chat chat : list) {
            if (chat.getNumberOfUsers() > TARGET_USERS) {
                result.add(chat);
            }
        }
        return result;
    }
}
