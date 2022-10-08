package com.artem.week2.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * Пример:
 * [-4, -18]
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 * [1, 9, 3]
 */
public class ArrayTask3 {

    private static final String POSITIVE = "Positive";
    private static final String NEGATIVE = "Negative";
    private static final String ZERO = "Zero";

    public static void main(String[] args) {
        int[] values = {-4, 0, 1, 9, 0, -18, 3};
        int[][] convertedArray = split(values);
        printArray(convertedArray);
    }

    private static void printArray(int[][] values) {
        for (int[] ints : values) {
            System.out.print(Arrays.toString(ints));
            System.out.println();
        }
    }

    private static int[][] split(int[] values) {
        return new int[][]{
                extractNegativeNumbers(values),
                extractZeroNumbers(values),
                extractPositiveNumbers(values)
        };
    }

    private static int[] extractNegativeNumbers(int[] values) {
        int[] resultArray = new int[calculateElements(values, NEGATIVE)];
        int currentIndex = 0;
        for (int value : values) {
            if (value < 0) {
                resultArray[currentIndex++] = value;
            }
        }
        return resultArray;
    }

    private static int[] extractZeroNumbers(int[] values) {
        int[] resultArray = new int[calculateElements(values, ZERO)];
        int currentIndex = 0;
        for (int value : values) {
            if (value == 0) {
                resultArray[currentIndex++] = value;
            }
        }
        return resultArray;
    }

    private static int[] extractPositiveNumbers(int[] values) {
        int[] resultArray = new int[calculateElements(values, POSITIVE)];
        int currentIndex = 0;
        for (int value : values) {
            if (value > 0) {
                resultArray[currentIndex++] = value;
            }
        }
        return resultArray;
    }

    private static int calculateElements(int[] values, String condition) {
        int count = 0;
        for (int value : values) {
            switch (condition) {
                case POSITIVE -> {
                    if (value > 0) count++;
                }
                case NEGATIVE -> {
                    if (value < 0) count++;
                }
                case ZERO -> {
                    if (value == 0) count++;
                }
            }
        }
        return count;
    }
}
