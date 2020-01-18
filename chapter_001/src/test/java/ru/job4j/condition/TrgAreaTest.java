package ru.job4j.condition;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrgAreaTest {

    @Test
    public void when001001() {
        Point first = new Point(0, 0);
        Point second = new Point(1, 0);
        Point third = new Point(0, 1);
        TrgArea trgArea = new TrgArea(first, second, third);
        double expected = 0.5;
        double result = trgArea.area();

        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void when002002() {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        Point third = new Point(0, 2);
        TrgArea trgArea = new TrgArea(first, second, third);
        double expected = 2.0;
        double result = trgArea.area();

        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void when112202() {
        Point first = new Point(1, 1);
        Point second = new Point(2, 2);
        Point third = new Point(0, 2);
        TrgArea trgArea = new TrgArea(first, second, third);
        double expected = 0.99;
        double result = trgArea.area();

        Assert.assertEquals(expected, result, 0.01);
    }

}