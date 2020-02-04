package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriorityIsFirstTask() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("one", 1));
        queue.put(new Task("five", 5));
        queue.put(new Task("three", 3));
        queue.put(new Task("nine", 9));
        queue.put(new Task("ten", 10));
        queue.put(new Task("two", 2));
        queue.put(new Task("six", 6));
        queue.put(new Task("eight", 8));
        queue.put(new Task("four", 4));
        queue.put(new Task("seven", 7));
        Task result = queue.take();
        assertThat(result.getDesc(), is("one"));
    }

    @Test
    public void whenHigherPriorityIsLastTask() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("five", 5));
        queue.put(new Task("three", 3));
        queue.put(new Task("nine", 9));
        queue.put(new Task("ten", 10));
        queue.put(new Task("two", 2));
        queue.put(new Task("six", 6));
        queue.put(new Task("eight", 8));
        queue.put(new Task("four", 4));
        queue.put(new Task("seven", 7));
        queue.put(new Task("one", 1));
        Task result = queue.take();
        assertThat(result.getDesc(), is("one"));
    }
}