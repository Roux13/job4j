package ru.job4j.grouping;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .flatMap(student -> student.getUnits().stream()
                        .map(u -> new Holder(u, student.getName())))
                .collect(Collectors.toMap(holder -> holder.key, holder -> Set.of(holder.value)));
    }

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
