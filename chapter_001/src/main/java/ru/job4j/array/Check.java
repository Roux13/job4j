package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        if (data.length > 0) {
            boolean reference = data[0];
            result = true;
            if (data.length > 1) {
                for (int i = 1; i < data.length; i++) {
                    if (data[i] != reference) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
