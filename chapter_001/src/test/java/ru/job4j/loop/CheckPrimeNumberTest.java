package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CheckPrimeNumberTest {

    @Test
    public void whenNeg() {
        boolean rsl = CheckPrimeNumber.check(-1);
        assertThat(rsl, is(false));
    }

    @Test
    public void when0() {
        boolean rsl = CheckPrimeNumber.check(0);
        assertThat(rsl, is(false));
    }

    @Test
    public void when1() {
        boolean rsl = CheckPrimeNumber.check(1);
        assertThat(rsl, is(false));
    }

    @Test
    public void when2() {
        boolean rsl = CheckPrimeNumber.check(2);
        assertThat(rsl, is(true));
    }

    @Test
    public void when5() {
        boolean rsl = CheckPrimeNumber.check(5);
        assertThat(rsl, is(true));
    }

    @Test
    public void when4() {
        boolean rsl = CheckPrimeNumber.check(4);
        assertThat(rsl, is(false));
    }

    @Test
    public void when37() {
        boolean rsl = CheckPrimeNumber.check(37);
        assertThat(rsl, is(true));
    }

    @Test
    public void when100() {
        boolean rsl = CheckPrimeNumber.check(100);
        assertThat(rsl, is(false));
    }

}