package com.artem.week2.string;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class StringTask1 {

    private static final String SPACE = " ";
    private static final String EMPTY = "";

    public static void main(String[] args) {
        String value = "abc Cpddd Dio OsfWw";
        StringBuilder result = convertToUpperCaseWithoutRepeatable(value);
        System.out.println(result);
    }

    private static StringBuilder convertToUpperCaseWithoutRepeatable(String value) {
        String withoutSpace = value.replace(SPACE, EMPTY).toUpperCase();
        char previousChar = withoutSpace.charAt(0);
        var result = new StringBuilder().append(previousChar);
        for (int i = 1; i < withoutSpace.length() - 1; i++) {
            char nextChar = withoutSpace.charAt(i);
            if (previousChar != nextChar) {
                result.append(nextChar);
                previousChar = nextChar;
            }
        }
        return result;
    }
}