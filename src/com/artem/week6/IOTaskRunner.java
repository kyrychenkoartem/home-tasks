package com.artem.week6;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import javafx.util.Pair;

public class IOTaskRunner {

    public static void main(String[] args) throws IOException {
        Path pathOfItemsPrice = Path.of("src", "com", "artem", "week6", "items-price.csv");
        Path pathOfItemsName = Path.of("src", "com", "artem", "week6", "items-name.csv");
        Path resultPath = Path.of("src", "com", "artem", "week6", "result.csv");
        Path errorPath = Path.of("src", "com", "artem", "week6", "errors.csv");
        List<ItemName> itemNames = IOReaderUtil.convertToItemName(pathOfItemsName);
        List<ItemPrice> itemPrices = IOReaderUtil.convertToItemPrice(pathOfItemsPrice);
        Pair<List<ItemResult>, List<ItemError>> combine = IOReaderUtil.combine(itemNames, itemPrices);
        IOWriterUtil.write(resultPath, errorPath, combine);
    }
}
