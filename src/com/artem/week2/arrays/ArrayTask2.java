package com.artem.week2.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы,
 * которые больше этого среднего арифметического.
 */
public class ArrayTask2 {

    public static void main(String[] args) {
        char[] values = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        printElements(values);
    }

    private static void printElements(char[] values) {
        int[] convertedArray = convertToIntArray(values);
        double average = calculateAverage(convertedArray);
        int[] resultArray = new int[calculateSize(convertedArray, average)];
        int currentIndex = 0;
        for (int i = 0; i < convertedArray.length; i++) {
            if (convertedArray[i] > average) {
                resultArray[currentIndex++] = convertedArray[i];
            }
        }
        System.out.println(Arrays.toString(resultArray));
    }

    private static int[] convertToIntArray(char[] values) {
        int[] resultArray = new int[values.length];
        int currentIndex = 0;
        for (int i = 0; i < values.length; i++) {
            resultArray[currentIndex++] = values[i];
        }
        return resultArray;
    }

    private static double calculateAverage(int[] values) {
        double avarage = 0;
        for (int i = 0; i < values.length; i++) {
            avarage += values[i];
        }
        avarage /= values.length;
        return avarage;
    }

    private static int calculateSize(int[] values, double avarage) {
        int size = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > avarage) {
                size++;
            }
        }
        return size;
    }
}
