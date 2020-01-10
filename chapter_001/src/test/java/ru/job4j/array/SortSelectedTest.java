package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {
    @Test
    public void whenSort() {
        int[] input = new int[] {3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenReverse() {
        int[] input = new int[] {5, 4, 3, 2, 1};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenHasDuplicates() {
        int[] input = new int[] {4, 4, 3, 2, 1};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenEvenLength() {
        int[] input = new int[] {2, 1, 4, 3};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4};
        assertThat(result, is(expect));
    }
}