package com.artem.week8.complaint;

import com.artem.week8.dto.ComplaintRow;
import com.artem.week8.util.StringUtils;
import java.time.LocalDateTime;

public class ProcessedComplaintGenerator implements Complaintable {

    private static final String REGEXP_PATTERN = "(\\+1)?\\s?\\(?(\\d{3})\\)?\\s?(\\d{3})-?\\s?(\\d{2})-?\\s?(\\d{2})";
    private static final String REPLACEMENT = "$1 ($2) $3-$4-$5";

    private static final String COUNTRY_CODE = "+1";
    private static final int TEN_SECONDS = 10;
    private static final String SECONDS_FORMAT = "0";

    @Override
    public String generate(ComplaintRow complaintRow) {
        return complaintRow.getId() + StringUtils.SEPARATOR + generateCallDateTime() + StringUtils.SEPARATOR
                + formatPhoneNumber(complaintRow.getPhoneNumber()) + System.lineSeparator();
    }

    private String generateCallDateTime() {
        int second = LocalDateTime.now().toLocalTime().getSecond();
        if (second < TEN_SECONDS) {
            String seconds = SECONDS_FORMAT + second;
            return LocalDateTime.now().toLocalDate().toString() + StringUtils.SPACE +
                    LocalDateTime.now().toLocalTime().getMinute() + StringUtils.COLON +
                    seconds;
        } else {
            return LocalDateTime.now().toLocalDate().toString() + StringUtils.SPACE +
                    LocalDateTime.now().toLocalTime().getMinute() + StringUtils.COLON +
                    LocalDateTime.now().toLocalTime().getSecond();
        }
    }

    public String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber.startsWith(COUNTRY_CODE)) {
            return phoneNumber.replaceAll(REGEXP_PATTERN, REPLACEMENT);
        } else {
            return COUNTRY_CODE + phoneNumber.replaceAll(REGEXP_PATTERN, REPLACEMENT);
        }
    }
}
