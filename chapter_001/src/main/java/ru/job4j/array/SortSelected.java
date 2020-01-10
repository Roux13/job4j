package ru.job4j.array;

public class SortSelected {
    public static int[] sort(int[] data) {
        int min = MinDiapason.findMin(data, 0, data.length);
        int index = FindLoop.indexOf(data, min, 0, data.length);
        int tmp = data[0];
        data[0] = min;
        data[index] = tmp;
        for (int i = 1; i < data.length; i++) {
            min = MinDiapason.findMin(data, i, data.length);
            index = FindLoop.indexOf(data, min, i, data.length);
            tmp = data[i];
            data[i] = min;
            data[index] = tmp;
        }
        return data;
    }

}
