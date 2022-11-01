package com.artem.week6;

import com.artem.week6.dto.ItemError;
import com.artem.week6.dto.ItemName;
import com.artem.week6.dto.ItemPrice;
import com.artem.week6.dto.ItemResult;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import static java.util.stream.Collectors.toMap;
import static java.util.function.Function.identity;

public final class IOHelperUtils {

    private static final int ZERO = 0;

    private IOHelperUtils() {
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
                .forEach(itemName -> map.computeIfPresent(itemName.id(),
                        (id, itemResult) -> new ItemResult(itemName.id(), itemName.name(), itemResult.price())));
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
//        return Stream.concat(
//                        itemNames.stream().map(ItemName::id),
//                        itemPrices.stream().map(ItemPrice::id))
//                .collect(groupingBy(identity(), counting()))
//                .entrySet().stream()
//                .filter(entry -> entry.getValue() == 1L)
//                .map(entry -> new ItemError(entry.getKey()))
//                .toList();
    }
}
