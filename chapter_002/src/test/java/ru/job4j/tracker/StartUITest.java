package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String message = "Fix PC";
        String[] answers = {message};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item(message);
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddNull() {
        String message = null;
        String[] answers = {message};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item(message);
        assertThat(created.getName(), is(expected.getName()));
    }
}