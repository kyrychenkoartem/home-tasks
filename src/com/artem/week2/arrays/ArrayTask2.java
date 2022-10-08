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
        int[] intArrays = convertToIntArray(values);
        System.out.println(Arrays.toString(intArrays));
        double average = calculateAverage(intArrays);
        printElementsAboveAverage(intArrays, average);
    }

    private static void printElementsAboveAverage(int[] convertedArray, double average) {
        for (int i = 0; i < convertedArray.length; i++) {
            if (convertedArray[i] > average) {
                System.out.println(convertedArray[i]);
            }
        }
    }

    private static int[] convertToIntArray(char[] values) {
        int[] resultArray = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            resultArray[i] = values[i];
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

}
