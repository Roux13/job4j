package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int tmp = 0;
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            tmp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = tmp;
        }
        return array;
    }
}
