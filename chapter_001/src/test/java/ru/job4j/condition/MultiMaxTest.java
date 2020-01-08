package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {

    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(4, 1, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 2, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenAllEquals() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 1, 1);
        assertThat(result, is(1));
    }

    @Test
    public void whenFirstAndSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(4, 4, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstAndThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(3, 1, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenSecondAndThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 5, 5);
        assertThat(result, is(5));
    }
}