package ru.job4j.condition;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;


class PointTest {

    @Test
    void distance0000() {
        int inX1 = 0;
        int inY1 = 0;
        int inX2 = 0;
        int inY2 = 0;
        double expected = 0.0;
        double out = Point.distance(inX1, inY1, inX2, inY2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    void distance0002() {
        int inX1 = 0;
        int inY1 = 0;
        int inX2 = 0;
        int inY2 = 2;
        double expected = 2.0;
        double out = Point.distance(inX1, inY1, inX2, inY2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    void distance0020() {
        int inX1 = 0;
        int inY1 = 0;
        int inX2 = 2;
        int inY2 = 0;
        double expected = 2.0;
        double out = Point.distance(inX1, inY1, inX2, inY2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    void distance0200() {
        int inX1 = 0;
        int inY1 = 2;
        int inX2 = 0;
        int inY2 = 0;
        double expected = 2.0;
        double out = Point.distance(inX1, inY1, inX2, inY2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    void distance2000() {
        int inX1 = 2;
        int inY1 = 0;
        int inX2 = 0;
        int inY2 = 0;
        double expected = 2.0;
        double out = Point.distance(inX1, inY1, inX2, inY2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    void distance1010() {
        int inX1 = 1;
        int inY1 = 0;
        int inX2 = 1;
        int inY2 = 0;
        double expected = 0.0;
        double out = Point.distance(inX1, inY1, inX2, inY2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    void distance1234() {
        int inX1 = 1;
        int inY1 = 2;
        int inX2 = 3;
        int inY2 = 4;
        double expected = 2.828;
        double out = Point.distance(inX1, inY1, inX2, inY2);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    void distanceNeg111Neg1() {
        int inX1 = -1;
        int inY1 = 1;
        int inX2 = 1;
        int inY2 = -1;
        double expected = 2.828;
        double out = Point.distance(inX1, inY1, inX2, inY2);

        Assert.assertEquals(expected, out, 0.01);
    }


}