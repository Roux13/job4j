package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        StubInput stubInput = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        new StartUI(stubInput, new Tracker(), System.out::println).init(Arrays.asList(action));
        assertThat(action.isCall(), is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void whenWrongInputFirstThenExit() {
        StubInput stubInput = new StubInput(new String[]{"1", "0"});
        StubAction action = new StubAction();
        new StartUI(stubInput, new Tracker(), System.out::println).init(Arrays.asList(action));
    }

    @Test
    public void init() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        StubInput stubInput = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        new StartUI(stubInput, new Tracker(), System.out::println).init(Arrays.asList(action));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .add("==============================")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdOut);
    }
}