package com.artem.week2.oop;

/**
 * Представить в виде классов и их композиции следующую модель.
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * В каждом классе реализовать метод print, который на консоль выводит информацию об объекте (должны присутствовать все поля объекта!).
 * Например, метод print класса этаж должен выводить на консоль:
 * “Этаж 2, количество квартир 18”
 * Создание всех объектов вынести в отдельный класс с методом main.
 * Там же реализовать метод printAllInformation, который на вход принимает объект типа дом,
 * и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 */
public class HouseRunner {

    public static void main(String[] args) {
        Bedroom bedroom1 = new Bedroom(true);
        Bedroom bedroom2 = new Bedroom(false);
        Bedroom bedroom3 = new Bedroom(true);
        Bedroom[] bedrooms1 = {bedroom1, bedroom2, bedroom3};
        Bedroom[] bedrooms2 = {bedroom1, bedroom2};
        Bedroom[] bedrooms3 = {bedroom1};
        Apartment apartment1 = new Apartment(1, bedrooms1);
        Apartment apartment2 = new Apartment(2, bedrooms2);
        Apartment apartment3 = new Apartment(3, bedrooms3);
        Apartment[] apartments1 = {apartment1, apartment2, apartment3};
        Apartment[] apartments2 = {apartment1, apartment2};
        Floor floor1 = new Floor(1, apartments1);
        Floor floor2 = new Floor(2, apartments2);
        Floor[] floors1 = {floor1, floor2};
        Floor[] floors2 = {floor1};
        House house1 = new House(1, floors1);
        House house2 = new House(2, floors2);
        printAllInformation(house1);
        printAllInformation(house2);
    }

    public static void printAllInformation(House house) {
        house.print();
    }
}





















