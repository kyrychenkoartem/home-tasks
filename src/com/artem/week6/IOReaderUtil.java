package com.artem.week6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javafx.util.Pair;


import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public final class IOReaderUtil {

    private static final int EXPECTED_LENGTH_NAME = 3;
    private static final int EXPECTED_LENGTH_PRICE = 2;
    private static final int DEFAULT_PRICE = -1;
    private static final int ZERO = 0;
    private static final long HEADER_ROWS = 1;
    private static final String COMMA = ",";

    private IOReaderUtil() {
    }

    public static Pair<List<ItemResult>, List<ItemError>> combine(List<ItemName> itemNames, List<ItemPrice> itemPrices) {
        Map<Integer, ItemResult> map = new LinkedHashMap<>();
        Map<Integer, ItemPrice> itemPriceMap = itemPrices.stream()
                .collect(toMap(ItemPrice::id, identity()));
        itemPriceMap.entrySet().stream()
                .filter(entry -> entry.getValue().price() > ZERO)
                .forEach(entry -> map.computeIfAbsent(entry.getKey(),
                        result -> new ItemResult(entry.getValue().id(), null, entry.getValue().price())));
        itemNames.stream()
                .filter(itemName -> itemName.name() != null || itemName.description() != null)
                .forEach(key -> map.computeIfPresent(key.id(), (integer, itemResult) -> new ItemResult(integer, key.name(), itemResult.price())));
//        for (Map.Entry<Integer, ItemPrice> entry : itemPriceMap.entrySet()) {
//            map.computeIfAbsent(entry.getKey(),
//                    result -> new ItemResult(entry.getValue().id(), null, entry.getValue().price()));
//        }
//            for (ItemName itemName : itemNames) {
//                map.computeIfPresent(itemName.id(), (integer, itemResult) -> new ItemResult(integer, itemName.name(), itemResult.price()));
//            }
        List<ItemResult> itemResults = map.values().stream().toList();
        return new Pair<>(itemResults, difference(itemNames, itemPrices));
    }

    public static List<ItemName> convertToItemName(Path path) throws IOException {
        if (Files.exists(path)) {
            try (Stream<String> lines = Files.lines(path, UTF_8)) {
                return lines
                        .skip(HEADER_ROWS)
                        .map(IOReaderUtil::getItemName)
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
                        .map(IOReaderUtil::getItemPrice)
                        .collect(toList());
            }
        } else {
            return new ArrayList<>();
        }
    }

    private static List<ItemError> difference(List<ItemName> itemNames, List<ItemPrice> itemPrices) {
        Map<Integer, ItemError> map = new LinkedHashMap<>();
        Map<Integer, ItemPrice> itemPriceMap = itemPrices.stream()
                .collect(toMap(ItemPrice::id, identity()));
        itemPriceMap.entrySet().stream()
                .filter(entry -> entry.getValue().price() < ZERO)
                .forEach(entry -> map.computeIfAbsent(entry.getKey(), result -> new ItemError(entry.getValue().id())));
        itemNames.stream()
                .filter(itemName -> itemName.name() == null || itemName.description() == null)
                .forEach(itemName -> map.computeIfAbsent(itemName.id(), itemError -> new ItemError(itemName.id())));
        return map.values().stream().toList();
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