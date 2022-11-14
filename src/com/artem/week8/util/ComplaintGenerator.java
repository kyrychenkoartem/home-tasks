package com.artem.week8.util;

import com.artem.week8.dto.ComplaintRow;
import java.time.LocalDateTime;
import java.util.Random;

public final class ComplaintGenerator {

    private static final Random RANDOM = new Random();

    private ComplaintGenerator() {
    }

    public static ComplaintRow generateNewComplaint() {
        return new ComplaintRow(
                ComplaintUtils.ID.getAndIncrement(),
                getLocalDateTime(),
                getFullName(ComplaintUtils.LAST_NAMES.get(getNext(ComplaintUtils.LAST_NAMES.size())),
                        ComplaintUtils.FIRST_NAMES.get(getNext(ComplaintUtils.FIRST_NAMES.size()))),
                ComplaintUtils.PHONE_NUMBERS.get(getNext(ComplaintUtils.PHONE_NUMBERS.size())),
                ComplaintUtils.COMPLAINTS.get(getNext(ComplaintUtils.COMPLAINTS.size())).getName());
    }

    private static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }

    private static String getFullName(String lastName, String firstName) {
        return lastName + " " + firstName;
    }

    private static LocalDateTime getLocalDateTime() {
        return ComplaintUtils.LOCAL_TIME
                .plusHours(ComplaintUtils.HOUR.getAndIncrement())
                .plusMinutes(ComplaintUtils.MINUTE.getAndIncrement())
                .plusSeconds(ComplaintUtils.SECOND.getAndIncrement());
    }
}
