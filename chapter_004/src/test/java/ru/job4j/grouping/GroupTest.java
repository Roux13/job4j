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

    @Test
    public void sectionsWhenTwoStudentOneSections() {
        Set<String> units1 = Set.of(section1);
        Set<String> units2 = Set.of(section1);
        Student student1 = new Student("Ivan", units1);
        Student student2 = new Student("Boris", units2);
        Map<String, Set<String>> expected = Map.of(
                section1, Set.of(student1.getName(), student2.getName())
        );
        Map<String, Set<String>> actual = Group.sections(List.of(student1, student2));
        assertThat(actual, is(expected));
    }

    @Test
    public void sectionsWhenManyStudentThreeSections() {
        Set<String> units1 = Set.of(section1);
        Set<String> units2 = Set.of(section2, section3);
        Set<String> units3 = Set.of(section1, section3);
        Student student1 = new Student("Ivan", units1);
        Student student2 = new Student("Boris", units2);
        Student student3 = new Student("John", units3);
        Map<String, Set<String>> expected = Map.of(
                section1, Set.of(student1.getName(), student3.getName()),
                section2, Set.of(student2.getName()),
                section3, Set.of(student2.getName(), student3.getName())
        );
        Map<String, Set<String>> actual = Group.sections(List.of(student1, student2, student3));
        assertThat(actual, is(expected));
    }
}