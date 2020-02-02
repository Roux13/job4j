package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when2by1() {
        Machine machine = new Machine();
        int[] expected = {1};
        int[] rsl = machine.change(2, 1);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when8by0() {
        Machine machine = new Machine();
        int[] expected = {5, 2, 1};
        int[] rsl = machine.change(8, 0);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when13by0() {
        Machine machine = new Machine();
        int[] expected = {10, 2, 1};
        int[] rsl = machine.change(13, 0);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when30by7() {
        Machine machine = new Machine();
        int[] expected = {10, 10, 2, 1};
        int[] rsl = machine.change(30, 7);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when19by0() {
        Machine machine = new Machine();
        int[] expected = {10, 5, 2, 2};
        int[] rsl = machine.change(19, 0);
        assertThat(rsl, is(expected));
    }
}