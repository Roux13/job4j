package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class SchoolTest {

    @Test
    public void collectWhenAThenScoresFrom70to100() {
        Student student10 = new Student(10);
        Student student30 = new Student(30);
        Student student50 = new Student(50);
        Student student70 = new Student(70);
        Student student90 = new Student(90);
        Student student100 = new Student(100);
        List<Student> students = List.of(
                student10,
                student100,
                student50,
                student30,
                student70,
                student90
        );
        List<Student> expect = List.of(
                student100,
                student70,
                student90
        );
        List<Student> result = new School().collect(students, s -> s.getScore() >= 70 && s.getScore() <= 100);
        assertThat(result, is(expect));
    }

    @Test
    public void collectWhenBThenScoresFrom50to70() {
        Student student10 = new Student(10);
        Student student30 = new Student(30);
        Student student50 = new Student(50);
        Student student70 = new Student(70);
        Student student90 = new Student(90);
        Student student100 = new Student(100);
        List<Student> students = List.of(
                student10,
                student100,
                student50,
                student30,
                student70,
                student90
        );
        List<Student> expect = List.of(
                student50
        );
        List<Student> result = new School().collect(students, s -> s.getScore() >= 50 && s.getScore() < 70);
        assertThat(result, is(expect));
    }

    @Test
    public void collectWhenCThenScoresFrom0to50() {
        Student student10 = new Student(10);
        Student student30 = new Student(30);
        Student student50 = new Student(50);
        Student student70 = new Student(70);
        Student student90 = new Student(90);
        Student student100 = new Student(100);
        List<Student> students = List.of(
                student10,
                student100,
                student50,
                student30,
                student70,
                student90
        );
        List<Student> expect = List.of(
                student10,
                student30
        );
        List<Student> result = new School().collect(students, s -> s.getScore() > 0 && s.getScore() < 50);
        assertThat(result, is(expect));
    }
}