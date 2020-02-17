package ru.job4j.grouping;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GroupTest {

    private String section1;
    private String section2;
    private String section3;

    @Before
    public void before() {
        section1 = "Basketball";
        section2 = "Tennis";
        section3 = "Painting";
    }

    @Test
    public void sectionsWhenOneStudentOneSection() {
        Set<String> units = Set.of(section1);
        Student student1 = new Student("Ivan", units);
        Map<String, Set<String>> expected = Map.of(section1, Set.of(student1.getName()));
        Map<String, Set<String>> actual = Group.sections(List.of(student1));
        assertThat(actual, is(expected));
    }

    @Test
    public void sectionsWhenOneStudentTwoSections() {
        Set<String> units = Set.of(section1, section2);
        Student student1 = new Student("Ivan", units);
        Map<String, Set<String>> expected = Map.of(
                section1, Set.of(student1.getName()),
                section2, Set.of(student1.getName()));
        Map<String, Set<String>> actual = Group.sections(List.of(student1));
        assertThat(actual, is(expected));
    }
}