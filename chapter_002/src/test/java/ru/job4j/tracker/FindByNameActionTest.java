package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class FindByNameActionTest {

    @Test
    public void whenCheckOutput() {
        String findName = "find";
        PrintStream std = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item(findName);
        tracker.add(item);
        FindByNameAction act = new FindByNameAction();
        StubInput stubInput = new StubInput(new String[]{findName});
        act.execute(stubInput, tracker, System.out::println);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Search Items by name ===")
                .add(item.getId() + " " + findName)
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(std);
    }

    @Test
    public void whenNameIsNullCheckOutput() {
        String findName = null;
        PrintStream std = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item(findName);
        tracker.add(item);
        FindByNameAction act = new FindByNameAction();
        StubInput stubInput = new StubInput(new String[]{findName});
        act.execute(stubInput, tracker, System.out::println);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Search Items by name ===")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(std);
    }

}