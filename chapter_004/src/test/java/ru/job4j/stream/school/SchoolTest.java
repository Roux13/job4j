package ru.job4j.stream.school;

import org.junit.Test;
import ru.job4j.stream.school.School;
import ru.job4j.stream.school.Student;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class SchoolTest {

    @Test
    public void collectWhenAThenScoresFrom70to100() {
        Student student10 = new Student("Sidorov", 10);
        Student student30 = new Student("Petrov", 30);
        Student student50 = new Student("Belkin", 50);
        Student student70 = new Student("Cherniy", 70);
        Student student90 = new Student("Churilin", 90);
        Student student100 = new Student("Grishin", 100);
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
        Student student10 = new Student("Sidorov", 10);
        Student student30 = new Student("Petrov", 30);
        Student student50 = new Student("Belkin", 50);
        Student student70 = new Student("Cherniy", 70);
        Student student90 = new Student("Churilin", 90);
        Student student100 = new Student("Grishin", 100);
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
        Student student10 = new Student("Sidorov", 10);
        Student student30 = new Student("Petrov", 30);
        Student student50 = new Student("Belkin", 50);
        Student student70 = new Student("Cherniy", 70);
        Student student90 = new Student("Churilin", 90);
        Student student100 = new Student("Grishin", 100);
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

    @Test
    public void convertListOfAllStudentsToMap() {
        Student student10 = new Student("Sidorov", 10);
        Student student30 = new Student("Petrov", 30);
        Student student50 = new Student("Belkin", 50);
        Student student70 = new Student("Cherniy", 70);
        Student student90 = new Student("Churilin", 90);
        Student student100 = new Student("Grishin", 100);
        List<Student> students = List.of(
                student10,
                student30,
                student50,
                student70,
                student90,
                student100
                );
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