package ru.job4j.collection;

import java.util.Comparator;

public class SortUserByAgeNaturalOrder implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return Integer.compare(u1.getAge(), u2.getAge());
    }
}
