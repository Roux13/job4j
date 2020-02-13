package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        String[] o1Elements = o1.split("/");
        String[] o2Elements = o2.split("/");
        int length = Integer.min(o1Elements.length, o2Elements.length);
        for (int i = 0; i < length; i++) {
            result = o2Elements[i].compareTo(o1Elements[i]);
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(o1Elements.length, o2Elements.length);
        }
        return result;
    }
}
