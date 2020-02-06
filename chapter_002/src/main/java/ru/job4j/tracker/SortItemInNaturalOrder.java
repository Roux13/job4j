package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemInNaturalOrder implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        if (first == null) {
            return second == null ? 0 : 1;
        }
        if (second == null) {
            return  -1;
        }
        if (first.getId() == null) {
            return second.getId() == null ? 0 : 1;
        }
        if (second.getId() == null) {
            return -1;
        }
        int result = first.getId().compareTo(second.getId());
        if (result != 0) {
            return result;
        }
        if (first.getName() == null) {
            return second.getName() == null ? 0 : 1;
        }
        if (second.getName() == null) {
            return -1;
        }
        return first.getName().compareTo(second.getName());
    }
}
