package ru.job4j.grouping;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .flatMap(student -> student.getUnits().stream()
                        .map(unit -> new Holder(unit, student.getName())))
                .collect(
                        Collectors.groupingBy(Holder::getKey,
                                Collector.of(HashSet::new,
                                        (set, holder) -> set.add(holder.getValue()),
                                        (left, right) -> {
                                                    left.addAll(right); return left;
                                                    }
                                                    )));
    }

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
