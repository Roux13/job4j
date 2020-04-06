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
        StartUI startUI = new StartUI(stubInput, new Tracker(), System.out::println);
        UserAction action = new ExitAction(startUI);
        startUI.init(Arrays.asList(action));

        assertThat(startUI.isRun(), is(false));
    }

    @Test(expected = IllegalStateException.class)
    public void whenWrongInputFirstThenExit() {
        StubInput stubInput = new StubInput(new String[]{"1", "0"});
        StartUI startUI = new StartUI(stubInput, new Tracker(), System.out::println);
        StubAction action = new StubAction(startUI);
        startUI.init(Arrays.asList(action));
    }

    @Test
    public void init() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        StubInput stubInput = new StubInput(new String[]{"0"});
        StartUI startUI = new StartUI(stubInput, new Tracker(), System.out::println);
        StubAction action = new StubAction(startUI);
        startUI.init(Arrays.asList(action));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .add("==============================")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdOut);
    }
}