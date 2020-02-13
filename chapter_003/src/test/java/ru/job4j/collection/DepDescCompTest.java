package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.lessThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void compareWhenK2lessThanK1() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void compareWhenK1GraterThanK2() {
        int rsl = new DepDescComp().compare(
                "K1",
                "K2"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void compareWhenEquals() {
        int rsl = new DepDescComp().compare(
                "K1",
                "K1"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void compareWhenK2SK1LessThanK1() {
        int rsl = new DepDescComp().compare(
                "K2/SK1",
                "K1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void compareWhenK2SK1SSK1LessThanK1() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK1",
                "K1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void compareWhenK1SK1SSK1GreaterThanK2() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK1",
                "K2"
        );
        assertThat(rsl, greaterThan(0));
    }
}