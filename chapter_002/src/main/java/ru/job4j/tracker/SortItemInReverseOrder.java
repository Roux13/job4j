package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemInReverseOrder implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return (-1) *  new SortItemInNaturalOrder().compare(first, second);
    }
}
