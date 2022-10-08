package com.artem.week2.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 */
public class ArrayTask1 {

    public static void main(String[] args) {
        int[] values = {3, 5, -6, 3, 2, -9, 0, -123};
        int[] resultArray = deleteNegativesAndMultiple(values);
        System.out.println(Arrays.toString(resultArray));
    }

    private static int[] deleteNegativesAndMultiple(int[] values) {
        int[] resultArray = new int[getSizeOfNonNegativeArray(values)];
        int currentIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 0) {
                resultArray[currentIndex++] = values[i];
            }
        }
        return multiplyByArrayLength(resultArray);
    }

    private static int[] multiplyByArrayLength(int[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i] * values.length;
        }
        return values;
    }

    private static int getSizeOfNonNegativeArray(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 0) {
                count++;
            }
        }
        return count;
    }
}
