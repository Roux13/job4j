package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {
    @Test
    public void whenTwoList() {
        List<int[]> in = List.of(
                (new int[]{1}),
                (new int[]{2, 3})
        );
        List<Integer> expect = List.of(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expect));
    }

    @Test
    public void when3ListAndOneOfThemEmpty() {
        List<int[]> in = List.of(
                (new int[]{1, 2, 3, 4, 5}),
                (new int[]{}),
                (new int[]{6, 7})
        );
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThat(ConvertList.convert(in), is(expect));
    }

}