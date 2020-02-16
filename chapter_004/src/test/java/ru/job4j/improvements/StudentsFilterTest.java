package ru.job4j.improvements;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentsFilterTest {

    @Test
    public void levelOfWhenStudentsSorted() {
        Student student1 = new Student("First", 50);
        Student student2 = new Student("Second", 75);
        Student student3 = new Student("Third", 90);
        List<Student> in = List.of(student1, student2, student3);
        List<Student> expect = List.of(student2, student3);
        List<Student> result = new StudentsFilter().levelOf(in, 70);
        assertThat(result, is(expect));
    }

    @Test
    public void levelOfWhenStudentsUnsorted() {
        Student student1 = new Student("First", 50);
        Student student2 = new Student("Second", 75);
        Student student3 = new Student("Third", 90);
        List<Student> in = List.of(student3, student2, student1);
        List<Student> expect = List.of(student2, student3);
        List<Student> result = new StudentsFilter().levelOf(in, 70);
        assertThat(result, is(expect));
    }

    @Test
    public void levelOfWhenHaveNullStudents() {
        Student student3 = new Student("Third", 90);
        Student student1 = new Student("First", 50);
        Student student2 = new Student("Second", 75);
        List<Student> in = new ArrayList<>();
        in.add(student3);
        in.add(student2);
        in.add(null);
        in.add(student1);
        List<Student> expect = List.of(student2, student3);
        List<Student> result = new StudentsFilter().levelOf(in, 70);
        assertThat(result, is(expect));
    }
}