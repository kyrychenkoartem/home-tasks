package com.artem.week4.part1.task1;

import com.artem.week4.part1.task1.comparator.ChatNameComparator;
import com.artem.week4.part1.task1.comparator.ChatNumberOfUsersComparator;
import java.util.ArrayList;
import java.util.List;

public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chatList = new ArrayList<>();
        chatList.add(new Chat("telegram", 3000));
        chatList.add(new Chat("viber", 2000));
        chatList.add(new Chat("whats-up", 1500));
        chatList.add(new Chat("messenger", 888));
        chatList.add(new Chat("slack", 2000));
        chatList.add(new Chat("skype", 999));
        chatList.add(new Chat("discord", 1500));
        System.out.println(chatList);
        List<Chat> modifiedChats = ChatUtils.deleteChatsFromList(chatList);
        System.out.println(modifiedChats);
        modifiedChats.sort(new ChatNumberOfUsersComparator().thenComparing(new ChatNameComparator()));
        System.out.println(modifiedChats);
    }
}
