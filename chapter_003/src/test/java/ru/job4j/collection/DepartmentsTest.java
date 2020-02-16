package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.sortAsc(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.sortAsc(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortAsc() {
        List<String> input = List.of("k2", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1", "k2");
        List<String> result = Departments.sortAsc(input);
        assertThat(result, is(expect));
    }


    @Test
    public void sortDesc() {
        List<String> input = List.of("k1/sk1", "k2");
        List<String> expect = List.of("k2", "k1", "k1/sk1");
        List<String> result = Departments.sortDesc(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortDescLargeTest() {
        List<String> input = List.of(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2");
        List<String> expect = List.of(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        );
        List<String> result = Departments.sortDesc(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortDescLargeTestWithMissed() {
        List<String> input = List.of(
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2");
        List<String> expect = List.of(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        );
        List<String> result = Departments.sortDesc(input);
        assertThat(result, is(expect));
    }
}