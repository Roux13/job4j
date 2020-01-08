package ru.job4j.loop;


import junit.framework.Assert;
import org.junit.Test;


public class CounterTest {

    @Test
    public void whenStartIs0FinishIs1(){
        Counter check = new Counter();
        int inStart = 0;
        int inFinish = 1;
        int out = check.add(inStart, inFinish);
        int expected = 0;

        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenStartIs1FinishIs2(){
        Counter check = new Counter();
        int inStart = 1;
        int inFinish = 2;
        int out = check.add(inStart, inFinish);
        int expected = 2;

        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenStartIs1FinishIs3(){
        Counter check = new Counter();
        int inStart = 1;
        int inFinish = 3;
        int out = check.add(inStart, inFinish);
        int expected = 2;

        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenStartIs1FinishIs10(){
        Counter check = new Counter();
        int inStart = 1;
        int inFinish = 10;
        int out = check.add(inStart, inFinish);
        int expected = 30;

        Assert.assertEquals(expected, out);
    }

}