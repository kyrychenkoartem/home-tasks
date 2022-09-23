package com.artem.task1;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 *
 * Протестировать функцию в main.
 */
public class Task1 {

    public static void main(String[] args) {
        int minutes = 14;
        printQuarter(minutes);
    }

    public static void printQuarter(int minutes) {
        if (minutes >= 0 && minutes < 15) {
            System.out.println(minutes + " minutes is in the first quarter");
        } else if (minutes >= 15 && minutes < 30) {
            System.out.println(minutes + " minutes is in the second quarter");
        } else if (minutes >= 30 && minutes < 45) {
            System.out.println(minutes + " minutes is in the third quarter");
        } else if (minutes >= 45 && minutes < 60) {
            System.out.println(minutes + " minutes is in the fourth quarter");
        } else {
            System.out.println("Incorrect value");
        }
    }
}
