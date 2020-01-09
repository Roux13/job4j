package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MortgageTest {

    @Test
    public void whenZeroPercent1Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(100, 100, 0);
        assertThat(year, is(1));
    }

    @Test
    public void whenZeroPercent100Years() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(100, 1, 0);
        assertThat(year, is(100));
    }

    @Test
    public void when1Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(1000, 1200, 1);
        assertThat(year, is(1));
    }

    @Test
    public void when2Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(100, 120, 50);
        assertThat(year, is(2));
    }
}