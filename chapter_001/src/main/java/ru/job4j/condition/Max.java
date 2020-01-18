package ru.job4j.condition;

public class Max {
    public static int max(int first, int second) {
        return first > second ? first : second;
    }

    public static int max(int first, int second, int third) {
        return Max.max(first, Max.max(second, third));
    }

    public static int max(int first, int second, int third, int fourth) {
        return Max.max(Max.max(first, second, third), fourth);
    }
}