package com.artem.week6;

import com.artem.week6.dto.ItemName;
import com.artem.week6.dto.ItemPrice;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public final class IOReaderUtils {

    private static final int EXPECTED_LENGTH_NAME = 3;
    private static final int EXPECTED_LENGTH_PRICE = 2;
    private static final int DEFAULT_PRICE = -1;
    private static final long HEADER_ROWS = 1;
    private static final String COMMA = ",";

    private IOReaderUtils() {
    }

    public static List<ItemName> convertToItemName(Path path) throws IOException {
        if (Files.exists(path)) {
            try (Stream<String> lines = Files.lines(path, UTF_8)) {
                return lines
                        .skip(HEADER_ROWS)
                        .map(IOReaderUtils::getItemName)
                        .collect(toList());
            }
        } else {
            return new ArrayList<>();
        }
    }

    public static List<ItemPrice> convertToItemPrice(Path path) throws IOException {
        if (Files.exists(path)) {
            try (Stream<String> lines = Files.lines(path, UTF_8)) {
                return lines
                        .skip(HEADER_ROWS)
                        .map(IOReaderUtils::getItemPrice)
                        .collect(toList());
            }
        } else {
            return new ArrayList<>();
        }
    }

    private static ItemName getItemName(String line) {
        String[] split = line.split(COMMA);
        if (split.length != EXPECTED_LENGTH_NAME) {
            return new ItemName(Integer.parseInt(split[0]), null, null);
        }
        return new ItemName(Integer.parseInt(split[0]), split[1], split[2]);
    }

    private static ItemPrice getItemPrice(String line) {
        String[] split = line.split(COMMA);
        if (split.length != EXPECTED_LENGTH_PRICE) {
            return new ItemPrice(Integer.parseInt(split[0]), DEFAULT_PRICE);
        }
        return new ItemPrice(Integer.parseInt(split[0]), Double.parseDouble(split[1]));
    }
}