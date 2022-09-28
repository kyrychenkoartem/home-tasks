package com.artem.week2.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * Пример:
 *                                     [-4, -18]
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 *                                     [1, 9, 3]
 */
public class ArrayTask3 {

    public static void main(String[] args) {
        int[] values = {-4, 0, 1, 9, 0, -18, 3};
        int[][] convertedArray = convertArray(values);
        printArray(convertedArray);
    }

    private static void printArray(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            int[] ints = values[i];
            System.out.print(Arrays.toString(ints));
            System.out.println();
        }
    }

    private static int[][] convertArray(int[] values) {
        int[][] resultArray = new int[3][];
        resultArray[0] = new int[calculateNegative(values)];
        resultArray[1] = new int[calculateZero(values)];
        resultArray[2] = new int[calculatePositive(values)];
        for (int i = 0, index1 = 0, index2 = 0, index3 = 0; i < values.length; i++) {
            if (values[i] < 0) {
                resultArray[0][index1++] = values[i];
            } else if (values[i] == 0) {
                resultArray[1][index2++] = values[i];
            } else if (values[i] > 0) {
                resultArray[2][index3++] = values[i];
            }
        }
        return resultArray;
    }

    private static int calculatePositive(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                count++;
            }
        }
        return count;
    }

    private static int calculateNegative(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < 0) {
                count++;
            }
        }
        return count;
    }

    private static int calculateZero(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 0) {
                count++;
            }
        }
        return count;
    }
}
