package com.artem.week8.parser;

import com.artem.week8.dto.ComplaintRow;
import com.artem.week8.util.StringUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import static java.util.function.Predicate.not;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class LogFileParser {

    private static final String ID_GROUP = "id";
    private static final String DATE_TIME_GROUP = "dateTime";
    private static final String FULL_NAME_GROUP = "fullName";
    private static final String PHONE_NUMBER_GROUP = "phoneNumber";
    private static final String COMPLAINT_GROUP = "complaint";
    private static final String LOG_FILE_REGEXP = "^(?<id>\\d+),\\s?(?<dateTime>(\\d{4}-\\d{2}-\\d{2})[T]+(\\d{2}:\\d{2}:\\d{2})),\\s?(?<fullName>.+?\\s?.+?),\\s?(?<phoneNumber>(\\+1)?\\s?\\(?\\d{3}\\)? ?\\d{3}-?\\d{2}-?\\d{2}),\\s?(?<complaint>[a-zA-Z\\s\\,]+?\\??)$";
    private static final Pattern PATTERN = Pattern.compile(LOG_FILE_REGEXP);

    public List<ComplaintRow> buildComplaintRaws(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.filter(not(StringUtils.EMPTY::equals))
                    .map(this::buildComplaintRaw)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(toList());
        }
    }

    private Optional<ComplaintRow> buildComplaintRaw(String line) {
        return Optional.of(line)
                .map(PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> {
                    var id = Integer.parseInt(matcher.group(ID_GROUP));
                    var dateTime = LocalDateTime.parse(matcher.group(DATE_TIME_GROUP), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    var fullName = matcher.group(FULL_NAME_GROUP);
                    var phoneNumber = matcher.group(PHONE_NUMBER_GROUP);
                    var complaint = matcher.group(COMPLAINT_GROUP);
                    return new ComplaintRow(id, dateTime, fullName, phoneNumber, complaint);
                });
    }
}
