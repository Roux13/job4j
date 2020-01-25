package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void drawTriangle5Height() {
        Triangle triangle = new Triangle();
        String result = triangle.draw();
        String expected = new StringBuilder()
                .append("    *    ").append("\n")
                .append("   ***   ").append("\n")
                .append("  *****  ").append("\n")
                .append(" ******* ").append("\n")
                .append("*********").append("\n").toString();
        assertThat(result, is(expected));

    }

}