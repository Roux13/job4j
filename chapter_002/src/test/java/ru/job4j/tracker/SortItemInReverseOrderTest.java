package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemInReverseOrderTest {

    @Test
    public void sort() {
        Item item1 = new Item("Bug");
        Item item2 = new Item("Reboot");
        item1.setId("123");
        item2.setId("321");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        List<Item> expect = Arrays.asList(item2, item1);
        Collections.sort(items, new SortItemInReverseOrder());
        assertThat(items, is(expect));
    }

    @Test
    public void sortWhenIdIsEqual() {
        Item item1 = new Item("Bug");
        Item item2 = new Item("Reboot");
        item1.setId("123");
        item2.setId("123");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        List<Item> expect = Arrays.asList(item2, item1);
        Collections.sort(items, new SortItemInReverseOrder());
        assertThat(items, is(expect));
    }

    @Test(expected = NullPointerException.class)
    public void sortWhenIdIsNull() {
        Item item1 = new Item("Reboot");
        Item item2 = new Item("Bug");
        item1.setId("321");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        Collections.sort(items, new SortItemInReverseOrder());
    }

    @Test(expected = NullPointerException.class)
    public void sortWhenNameIsNull() {
        Item item1 = new Item("Reboot");
        Item item2 = new Item(null);
        item1.setId("321");
        item2.setId("321");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        Collections.sort(items, new SortItemInReverseOrder());
    }
}