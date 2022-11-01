package com.artem.week6;

import com.artem.week6.dto.ItemError;
import com.artem.week6.dto.ItemName;
import com.artem.week6.dto.ItemPrice;
import com.artem.week6.dto.ItemResult;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import javafx.util.Pair;

public class IOTaskRunner {

    public static final String PATH_RESOURCES = "resources";
    public static final String PATH_ITEMS_NAME = "items-name.csv";
    public static final String PATH_ITEMS_PRICE = "items-price.csv";
    public static final String PATH_RESULT = "result.csv";
    public static final String PATH_ERRORS = "errors.csv";

    public static void main(String[] args) throws IOException {
        Path pathOfItemsPrice = Path.of(PATH_RESOURCES, PATH_ITEMS_PRICE);
        Path pathOfItemsName = Path.of(PATH_RESOURCES, PATH_ITEMS_NAME);
        Path resultPath = Path.of(PATH_RESOURCES, PATH_RESULT);
        Path errorPath = Path.of(PATH_RESOURCES, PATH_ERRORS);
        List<ItemName> itemNames = IOReaderUtils.convertToItemName(pathOfItemsName);
        List<ItemPrice> itemPrices = IOReaderUtils.convertToItemPrice(pathOfItemsPrice);
        Pair<List<ItemResult>, List<ItemError>> combine = IOHelperUtils.combine(itemNames, itemPrices);
        IOWriterUtils.write(resultPath, errorPath, combine);
    }
}