package ru.job4j.calculator;

import java.util.Locale;

public class Calculator{

    public static void add(double first, double second) {
        System.out.printf(Locale.ENGLISH, "%,.1f + %,.1f = %,.1f%n", first, second, first + second);
    }

    public static void div(double first, double second) {
        System.out.printf(Locale.ENGLISH, "%,.1f / %,.1f = %,.1f%n", first, second, first / second);
    }

    public static void multiply(double first, double second) {
        System.out.printf(Locale.ENGLISH, "%,.1f * %,.1f = %,.1f%n", first, second, first * second);
    }

    public static void subtrack(double first, double second) {
        System.out.printf(Locale.ENGLISH, "%,.1f - %,.1f = %,.1f%n", first, second, first - second);
    }

    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }

}