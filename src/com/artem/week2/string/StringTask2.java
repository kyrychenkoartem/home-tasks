package com.artem.week2.string;

import java.util.Arrays;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * Посчитать сумму всех чисел из строки
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class StringTask2 {

    public static void main(String[] args) {
        String value = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        int[] resultArray = split(value);
        System.out.println(Arrays.toString(resultArray));
        int resultSum = countSum(resultArray);
        System.out.println("The sum of the numbers in the array is: " + resultSum);
    }

    private static int[] split(String value) {
        int[] result = new int[countArraySize(value)];
        int counter = 0;
        for (int i = 0; i < value.length(); i++) {
            boolean isDigit = Character.isDigit(value.charAt(i));
            if (isDigit) {
                int currentInteger = Integer.parseInt(String.valueOf(value.charAt(i)));
                result[counter++] = currentInteger;
            }
        }
        return result;
    }

    private static int countSum(int[] value) {
        int counter = 0;
        for (int i = 0; i < value.length; i++) {
            counter += value[i];
        }
        return counter;
    }

    private static int countArraySize(String value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
