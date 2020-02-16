package ru.job4j.improvements;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsFilter {

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .filter(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }

}
