package com.artem.task1;

/**
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 *
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */
public class Task3 {
    public static void main(String[] args) {
        double triangle1 = calculateArea(2.0, 3.0);
        double triangle2= calculateArea(1.0, 6.0);
        compareArea(triangle1, triangle2);
    }

    public static double calculateArea(double a, double b) {
        return (a * b) / 2;
    }

    public static void compareArea(double triangle1, double triangle2) {
        if (triangle1 > triangle2) {
            System.out.println("The area of triangle A - " + triangle1 + " is greater than the area of triangle B - " + triangle2);
        } else if (triangle1 < triangle2) {
            System.out.println("The area of triangle A - " + triangle1 + " is less than the area of triangle B - " + triangle2);
        } else {
            System.out.println("The areas of triangles A and B are equal");
        }
    }
}
