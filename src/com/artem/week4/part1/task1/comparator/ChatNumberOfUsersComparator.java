package com.artem.week4.part1.task1.comparator;

import com.artem.week4.part1.task1.Chat;
import java.util.Comparator;

public class ChatNumberOfUsersComparator implements Comparator<Chat> {

    @Override
    public int compare(Chat o1, Chat o2) {
        return Integer.compare(o2.numberOfUsers(), o1.numberOfUsers());
    }
}