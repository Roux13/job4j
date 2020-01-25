package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        StubInput stubInput = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        new StartUI().init(stubInput, new Tracker(), new UserAction[]{action});
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenWrongInputFirstThenExit() {
        StubInput stubInput = new StubInput(new String[]{"1", "0"});
        StubAction action = new StubAction();
        new StartUI().init(stubInput, new Tracker(), new UserAction[]{action});
        assertThat(action.isCall(), is(true));
    }
}