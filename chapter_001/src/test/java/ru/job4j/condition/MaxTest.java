package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax3To1Then3() {
        int result = Max.max(3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenLeftEqualsRightThenWhatever() {
        int result = Max.max(1, 1);
        assertThat(result, is(1));
    }

    @Test
    public void whenMaxNeg2To1Then1() {
        int result = Max.max(-2, 1);
        assertThat(result, is(1));
    }

    @Test
    public void when1Or2Or3Then3() {
        int result = Max.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void when2Or3Or1Then3() {
        int result = Max.max(2, 3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void when3Or1Or2Then3() {
        int result = Max.max(3, 1, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenAllAre1Then1() {
        int result = Max.max(1, 1, 1);
        assertThat(result, is(1));
    }

    @Test
    public void when1Or2Or3Or4Then4() {
        int result = Max.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }

    @Test
    public void when4Or1Or2Or3Then4() {
        int result = Max.max(4, 1, 2, 3);
        assertThat(result, is(4));
    }

    @Test
    public void when3Or4Or1Or2Then4() {
        int result = Max.max(3, 4, 1, 2);
        assertThat(result, is(4));
    }

    @Test
    public void when2Or3Or4Or1Then4() {
        int result = Max.max(2, 3, 4, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenAllAre4Then4() {
        int result = Max.max(4, 4, 4, 4);
        assertThat(result, is(4));
    }
}