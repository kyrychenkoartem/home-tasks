package com.artem.week1.loop;

import java.util.Scanner;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * <p>
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int reverse = reverse(value);
        System.out.println(reverse);
    }

    private static int reverse(int value) {
        StringBuilder result = new StringBuilder();
        for (int currentValue = value; currentValue != 0; currentValue /= 10) {
            result.append(currentValue % 10);
        }
        return Integer.parseInt(result.toString());
    }
}
