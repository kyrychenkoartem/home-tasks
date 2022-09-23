package com.artem.task2;

import java.util.Scanner;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция - нечетных).
 *
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int countEven = countEven(value);
        int countOdd = countOdd(value);
        System.out.println(countEven + " even numbers in " + value);
        System.out.println(countOdd + " odd numbers in " + value);
    }

    public static int countEven(int value) {
        int result = 0;
            for (int currentValue = value; currentValue != 0; currentValue /= 10) {
                if (currentValue % 10 == 1
                        || currentValue % 10 == 3
                        || currentValue % 10 == 5
                        || currentValue % 10 == 7
                        || currentValue % 10 == 9) {
                    continue;
                } else {
                    result += 1;
                }
        }
        return result;
    }

    public static int countOdd(int value) {
        int result = 0;
        for (int currentValue = value; currentValue != 0; currentValue /= 10) {
            if (currentValue % 10 == 0
                    || currentValue % 10 == 2
                    || currentValue % 10 == 4
                    || currentValue % 10 == 6
                    || currentValue % 10 == 8) {
                continue;
            } else {
                result += 1;
            }
        }
        return result;
    }


}
