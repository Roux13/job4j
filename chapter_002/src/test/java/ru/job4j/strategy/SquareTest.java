package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SquareTest {

    @Test
    public void draw7By7Square() {
        Square square = new Square();
        String result = square.draw();
        String expected = new StringBuilder().append("*  *  *  *  *  *  *").append("\n")
                .append("*                 *").append("\n")
                .append("*                 *").append("\n")
                .append("*                 *").append("\n")
                .append("*                 *").append("\n")
                .append("*                 *").append("\n")
                .append("*  *  *  *  *  *  *").append("\n").toString();
        assertThat(result, is(expected));
    }
}