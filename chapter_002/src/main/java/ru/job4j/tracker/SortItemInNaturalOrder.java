package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemInNaturalOrder implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        int result = first.getId().compareTo(second.getId());
        return result != 0 ? result : first.getName().compareTo(second.getName());
    }
}
