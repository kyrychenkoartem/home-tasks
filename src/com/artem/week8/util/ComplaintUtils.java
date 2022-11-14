package com.artem.week8.util;

import com.artem.week8.dto.ComplaintType;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ComplaintUtils {
    public static final AtomicInteger ID = new AtomicInteger(1);
    public static final AtomicInteger YEAR = new AtomicInteger(2020);
    public static final AtomicInteger MONTH = new AtomicInteger(3);
    public static final AtomicInteger DAY_OF_MONTH = new AtomicInteger(22);
    public static final AtomicInteger HOUR = new AtomicInteger(1);
    public static final AtomicInteger MINUTE = new AtomicInteger(44);
    public static final AtomicInteger SECOND = new AtomicInteger(55);
    public static LocalDateTime LOCAL_TIME = LocalDateTime.of(YEAR.get(), MONTH.get(), DAY_OF_MONTH.get(), HOUR.get(), MINUTE.get(), SECOND.get());
    public static final List<String> LAST_NAMES = List.of(
            "Mccarthy", "Crawford","Hunt","Burke","Berry",
            "Holmes","Mcbride","Snyder","Fleming","Abbott",
            "Kelley","Elliott","Walton","Rivera","Johnston");
    public static final List<String> FIRST_NAMES = List.of(
            "Alec", "Mitchell", "Eddie", "Otis", "Christopher",
            "Rafael", "Bailey", "Rocco", "May", "Aimee",
            "Georgie", "Kaitlyn", "Fannie", "Rhea", "Maria");
    public static final List<String> PHONE_NUMBERS = List.of(
            "+1 690 4967385", "+14759385740", "3756385960" ,"+12746386995", "5847365038",
            "+1 567 3958673", "+15748306758", "5444666666" ,"+14678535679", "3456745747",
            "+1 357 2995847", "+14486038695", "2234567899" ,"+13958883769", "5558990457");
    public static final List<ComplaintType> COMPLAINTS = Arrays.asList(ComplaintType.values());

    private ComplaintUtils() {
    }
}
