package com.artem.week1.loop;

import java.util.Scanner;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция - нечетных).
 * <p>
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

    private static int countEven(int value) {
        int result = 0;
        int currentValue = value;
        while (currentValue != 0) {
            int lastDigit = currentValue % 10;
            if (lastDigit % 2 == 0) {
                result++;
            }
            currentValue /= 10;
        }
        return result;
    }

    private static int countOdd(int value) {
        int result = 0;
        int currentValue = value;
        while (currentValue != 0) {
            int lastDigit = currentValue % 10;
            if (lastDigit % 2 != 0) {
                result++;
            }
            currentValue /= 10;
        }
        return result;
    }


}
