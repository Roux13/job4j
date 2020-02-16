package ru.job4j.stream.school;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class SchoolTest {

    private Student student10;
    private Student student30;
    private Student student50;
    private Student student70;
    private Student student90;
    private Student student100;

    private List<Student> students;

    @Before
    public void before() {
        student10 = new Student("Sidorov", 10);
        student30 = new Student("Petrov", 30);
        student50 = new Student("Belkin", 50);
        student70 = new Student("Cherniy", 70);
        student90 = new Student("Churilin", 90);
        student100 = new Student("Grishin", 100);
        students = List.of(
                student10,
                student100,
                student50,
                student30,
                student70,
                student90
        );
    }

    @Test
    public void collectWhenAThenScoresFrom70to100() {
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
        List<Student> expect = List.of(
                student50
        );
        List<Student> result = new School().collect(students, s -> s.getScore() >= 50 && s.getScore() < 70);
        assertThat(result, is(expect));
    }

    @Test
    public void collectWhenCThenScoresFrom0to50() {
        List<Student> expect = List.of(
                student10,
                student30
        );
        List<Student> result = new School().collect(students, s -> s.getScore() > 0 && s.getScore() < 50);
        assertThat(result, is(expect));
    }

    @Test
    public void convertListOfAllStudentsToMap() {
        Map<String, Student> expect = Map.of(
                student10.getLastName(), student10,
                student30.getLastName(), student30,
                student50.getLastName(), student50,
                student70.getLastName(), student70,
                student90.getLastName(), student90,
                student100.getLastName(), student100
        );
        School school = new School();
        List<Student> allStudents = school.collect(students, s -> s.getScore() > 0 && s.getScore() <= 100);
        Map<String, Student> result = school.convertListToMap(allStudents);
        assertThat(result, is(expect));
    }
}