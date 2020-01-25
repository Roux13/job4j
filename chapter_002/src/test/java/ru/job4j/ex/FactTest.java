package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLessThen1() {
        new Fact().calc(0);
    }

    @Test
    public void when1Then1() {
        int n = 1;
        int result = new Fact().calc(n);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void when3Then6() {
        int n = 3;
        int result = new Fact().calc(n);
        int expected = 6;
        assertThat(result, is(expected));
    }

    @Test
    public void when5Then120() {
        int n = 5;
        int result = new Fact().calc(n);
        int expected = 120;
        assertThat(result, is(expected));
    }
}