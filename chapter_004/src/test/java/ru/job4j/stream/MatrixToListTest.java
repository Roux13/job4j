package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class MatrixToListTest {

    @Test
    public void convertWhenMatrix2By2() {
        Integer[][] matrix = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = List.of(1, 2, 3, 4);
        List<Integer> result = new MatrixToList().convert(matrix);
        assertThat(result, is(expect));
    }

    @Test
    public void convertWhenMatrix3By1() {
        Integer[][] matrix = {
                {1},
                {2},
                {3}
        };
        List<Integer> expect = List.of(1, 2, 3);
        List<Integer> result = new MatrixToList().convert(matrix);
        assertThat(result, is(expect));
    }

}