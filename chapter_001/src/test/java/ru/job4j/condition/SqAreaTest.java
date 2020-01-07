package ru.job4j.condition;

import junit.framework.Assert;
import org.junit.Test;


public class SqAreaTest {

    @Test
    public void squareP4K1() {
        int inP = 4;
        int inK = 1;
        double expected = 1.0;
        double out = SqArea.square(inP, inK);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void squareP6K2() {
        int inP = 6;
        int inK = 2;
        double expected = 2.0;
        double out = SqArea.square(inP, inK);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void squareP4KNeg1() {
        int inP = 4;
        int inK = -1;
        double expected = Double.NEGATIVE_INFINITY;
        double out = SqArea.square(inP, inK);

        Assert.assertEquals(expected, out, 0.01);
    }
}