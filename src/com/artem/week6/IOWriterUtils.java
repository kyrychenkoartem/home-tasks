package com.artem.week6;

import com.artem.week6.dto.ItemError;
import com.artem.week6.dto.ItemResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import static java.nio.file.StandardOpenOption.CREATE;

public final class IOWriterUtils {

    private static final String COMMA = ",";
    private static final String RESULT_HEADER_ROW = "ID,NAME,DESCRIPTION";
    private static final String ERROR_HEADER_ROW = "ID";

    private IOWriterUtils() {
    }

    public static void write(Path resultPath, Path errorPath, Pair<List<ItemResult>, List<ItemError>> listPair) throws IOException {
        List<String> itemResultList = writeResultToCsv(listPair.getKey());
        List<String> itemErrorList = writeErrorToCsv(listPair.getValue());
        Files.write(resultPath, itemResultList, CREATE);
        Files.write(errorPath, itemErrorList, CREATE);
    }

    private static List<String> writeResultToCsv(List<ItemResult> itemResults) {
        List<String> list = new ArrayList<>();
        list.add(RESULT_HEADER_ROW);
        itemResults.stream()
                .map(item -> item.id() + COMMA + item.name() + COMMA + item.price())
                .forEach(list::add);
        return list;
    }

    private static List<String> writeErrorToCsv(List<ItemError> itemErrors) {
        List<String> list = new ArrayList<>();
        list.add(ERROR_HEADER_ROW);
        itemErrors.stream()
                .map(error -> String.valueOf(error.id()))
                .forEach(list::add);
        return list;
    }
}