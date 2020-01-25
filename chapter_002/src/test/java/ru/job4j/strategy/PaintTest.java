package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(stdOut);
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        String expected = new StringBuilder().append("*  *  *  *  *  *  *").append("\n")
                .append("*                 *").append("\n")
                .append("*                 *").append("\n")
                .append("*                 *").append("\n")
                .append("*                 *").append("\n")
                .append("*                 *").append("\n")
                .append("*  *  *  *  *  *  *").append("\n").append(System.lineSeparator()).toString();
        assertThat(out.toString(), is(expected));
        System.setOut(stdOut);
    }
}