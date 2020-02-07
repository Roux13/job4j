package ru.job4j.collection;

import java.util.Comparator;

public class SortUserByNameReverseOrder implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return u2.getName().compareTo(u1.getName());
    }
}
