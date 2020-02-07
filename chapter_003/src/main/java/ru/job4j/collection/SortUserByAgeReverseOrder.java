package ru.job4j.collection;

import java.util.Comparator;

public class SortUserByAgeReverseOrder implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return Integer.compare(u2.getAge(), u1.getAge());
    }
}
