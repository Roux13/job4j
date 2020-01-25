package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(new Fact().calc(1));
    }

    public int calc(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Argument n should be more or equals by 1");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
