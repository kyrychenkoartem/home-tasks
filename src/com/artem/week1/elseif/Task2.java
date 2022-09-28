package com.artem.week1.elseif;

/**
 * Даны 3 переменные:
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */
public class Task2 {

    public static void main(String[] args) {
        double operand1 = 10.0;
        double operand2 = 2.0;
        char operation = '/';
        double result = getResult(operand1, operand2, operation);
        System.out.println(result);

    }

    private static double getResult(double d1, double d2, char operation) {
        if (operation == '+') {
            return d1 + d2;
        } else if (operation == '-') {
            return d1 - d2;
        } else if (operation == '*') {
            return d1 * d2;
        } else if (operation == '/') {
            return d1 / d2;
        } else if (operation == '%') {
            return d1 % d2;
        } else {
            throw new IllegalArgumentException("Please enter correct data");
        }
    }
}
