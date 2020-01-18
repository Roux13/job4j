package ru.job4j.condition;

import junit.framework.Assert;
import org.junit.Test;


public class PointTest {

    @Test
    public void distance0000() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        double expected = 0.0;
        double out = p1.distance(p2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance0002() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        double expected = 2.0;
        double out = p1.distance(p2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance0020() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        double expected = 2.0;
        double out = p1.distance(p2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance0200() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(0, 0);
        double expected = 2.0;
        double out = p1.distance(p2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance2000() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(0, 0);
        double expected = 2.0;
        double out = p1.distance(p2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance1010() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(1, 0);
        double expected = 0.0;
        double out = p1.distance(p2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance1234() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        double expected = 2.828;
        double out = p1.distance(p2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distanceNeg111Neg1() {
        Point p1 = new Point(-1, 1);
        Point p2 = new Point(1, -1);
        double expected = 2.828;
        double out = p1.distance(p2);

        Assert.assertEquals(expected, out, 0.01);
    }
}