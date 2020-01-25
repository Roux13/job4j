package ru.job4j.strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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