package ru.job4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionInDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionInDiapason function = new FunctionInDiapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        FunctionInDiapason function = new FunctionInDiapason();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunction() {
        FunctionInDiapason function = new FunctionInDiapason();
        List<Double> result = function.diapason(5, 8, x -> Math.log10(x));
        double[] expected = {0.699, 0.778, 0.845};
        double[] resultArray = new double[result.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        assertArrayEquals(expected, resultArray, 0.001);
    }

}