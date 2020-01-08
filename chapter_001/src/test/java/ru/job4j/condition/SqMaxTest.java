package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SqMaxTest {

    @Test
    public void whenFirstMax() {
        int result = SqMax.max(4, 3, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax() {
        int result = SqMax.max(3, 5, 2, 1);
        assertThat(result, is(5));
    }

    @Test
    public void whenThirdMax() {
        int result = SqMax.max(3, 5, 6, 1);
        assertThat(result, is(6));
    }

    @Test
    public void whenFourthMax() {
        int result = SqMax.max(3, 5, 6, 7);
        assertThat(result, is(7));
    }

    @Test
    public void whenAllEquals() {
        int result = SqMax.max(9, 9, 9, 9);
        assertThat(result, is(9));
    }

    @Test
    public void whenThirdMaxAndMinFour() {
        int result = SqMax.max(4, 3, 12, 1);
        assertThat(result, is(12));
    }
}