package com.artem.week8.util;

import java.nio.file.Path;

public final class PathUtils {

    public static final Path COMPLAINTS_PATH = Path.of("resources", "complaints.log");
    public static final Path RESULT_PATH = Path.of("resources", "result.log");
    private PathUtils() {
    }
}
