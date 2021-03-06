package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByTrueThenTrueEven() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalseEven() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByFalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataNotMonoByLastDifferentThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataEmptyThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataHasOneValueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}