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

    @Test
    public void whenReplaceItem() {
        String newMessage = "New Item";
        String replacedMessage = "Replaced Item";
        Tracker tracker = new Tracker();
        Item item = new Item(newMessage);
        tracker.add(item);
        String[] answers = {item.getId(), replacedMessage};
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is(replacedMessage));
    }

    @Test
    public void whenDeleteItem() {
        String newMessage = "New Item";
        Tracker tracker = new Tracker();
        Item item = new Item(newMessage);
        tracker.add(item);
        String[] answers = {item.getId()};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        Item expected = null;
        assertThat(deleted, is(expected));
    }
}