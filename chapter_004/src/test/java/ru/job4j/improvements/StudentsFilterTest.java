package ru.job4j.improvements;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentsFilterTest {

    private Student student1;
    private Student student2;
    private Student student3;

    @Before
    public void before() {
        student1 = new Student("Third", 90);
        student2 = new Student("Second", 75);
        student3 = new Student("First", 50);
    }

    @Test
    public void levelOfWhenStudentsSorted() {
        List<Student> in = List.of(student1, student2, student3);
        List<Student> expect = List.of(student1, student2);
        List<Student> result = new StudentsFilter().levelOf(in, 70);
        assertThat(result, is(expect));
    }

    @Test
    public void levelOfWhenStudentsUnsorted() {
        List<Student> in = List.of(student3, student2, student1);
        List<Student> expect = List.of(student1, student2);
        List<Student> result = new StudentsFilter().levelOf(in, 70);
        assertThat(result, is(expect));
    }

    @Test
    public void levelOfWhenHaveNullStudents() {
        List<Student> in = new ArrayList<>();
        in.add(student3);
        in.add(student2);
        in.add(null);
        in.add(student1);
        List<Student> expect = List.of(student1, student2);
        List<Student> result = new StudentsFilter().levelOf(in, 70);
        assertThat(result, is(expect));
    }
}