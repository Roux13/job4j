package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        PrintStream std = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ValidateInput validateInput = new ValidateInput(
                new StubInput(new String[] {"one", "1"}), System.out::println);
        validateInput.askInt("Enter");
        assertThat(out.toString(), is(String.format("Please enter validate data again.%n")));
        System.setOut(std);
    }

    @Test
    public void whenValidInput() {
        ValidateInput validateInput = new ValidateInput(
                new StubInput(new String[] {"0"}), System.out::println);
        int result = validateInput.askInt("Enter");
        assertThat(result, is(0));
    }

    @Test
    public void whenFirstWrongKeyInputAfterValidKey() {
        PrintStream std = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ValidateInput validateInput = new ValidateInput(
                new StubInput(new String[] {"1", "0"}), System.out::println);
        validateInput.askInt("Enter", 1);
        assertThat(out.toString(), is(String.format("Please select key from menu.%n")));
        System.setOut(std);
    }

    @Test
    public void whenValidKey() {
        ValidateInput validateInput = new ValidateInput(
                new StubInput(new String[] {"0"}), System.out::println);
        int result = validateInput.askInt("Enter", 1);
        assertThat(result, is(0));

    }
}