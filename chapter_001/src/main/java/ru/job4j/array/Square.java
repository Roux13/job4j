package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int index = 1; index <= bound; index++) {
            rst[index - 1] = index * index;
        }
        return rst;
    }
}
