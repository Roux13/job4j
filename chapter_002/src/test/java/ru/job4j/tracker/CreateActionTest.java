package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class CreateActionTest {

    @Test
    public void whenDeleteItem() {
        String newMessage = "New Item";
        Tracker tracker = new Tracker();
        String[] answers = {newMessage};
        new CreateAction().execute(new StubInput(answers), tracker);
        Item added = tracker.findAll().get(0);
        String expected = newMessage;
        assertThat(added.getName(), is(expected));
    }

}