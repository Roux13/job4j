package ru.job4j.calculator;

import junit.framework.Assert;
import org.junit.Test;


public class FitTest {

    @Test
    public void manWeight() {
        double in = 178.0;
        double expected = 89.7;
        double out = Fit.manWeight(in);

        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void womanWeight() {
        double in = 173.0;
        double expected = 72.45;
        double out = Fit.womanWeight(in);

        Assert.assertEquals(expected, out, 0.01);
    }
}