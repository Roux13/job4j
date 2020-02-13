package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps, Comparator<String> comp) {
        Set<String> tmp = new TreeSet<>(comp);
        for (String value : deps) {
            String start = "";
            boolean firstEl = true;
            for (String el : value.split("/")) {
                start = firstEl ? start + el : start + "/" + el;
                firstEl = false;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static List<String> sortAsc(List<String> deps) {
        return fillGaps(deps, Comparator.naturalOrder());
    }

    public static List<String> sortDesc(List<String> deps) {
        return fillGaps(deps, new DepDescComp());
    }
}