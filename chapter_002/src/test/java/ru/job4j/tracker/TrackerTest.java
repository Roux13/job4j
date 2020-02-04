package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenAddTwoItemsThenTrackerFindAllReturnAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> expect = Arrays.asList(item1, item2);
        List<Item> result = tracker.findAll();
        assertThat(result, is(expect));
    }

    @Test
    public void whenNoItemsWereAddedThenTrackerFindAllReturnEmptyArray() {
        Tracker tracker = new Tracker();
        List<Item> expect = Arrays.asList();
        List<Item> result = tracker.findAll();
        assertThat(result, is(expect));
    }

    @Test
    public void whenAddTwoDifferentItemsThenTrackerFindByNameOneItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> expect = Arrays.asList(item1);
        List<Item> result = tracker.findByName(item1.getName());
        assertThat(result, is(expect));
    }

    @Test
    public void whenAddTwoSameItemsThenTrackerFindByNameTwoItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test1");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expect = Arrays.asList(item1, item3);
        List<Item> result = tracker.findByName(item1.getName());
        assertThat(result, is(expect));
    }

    @Test
    public void whenAddAnyItemsAndFindNameWrongThenTrackerFindByNameEmpty() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test1");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expect = Arrays.asList();
        List<Item> result = tracker.findByName("wrong");
        assertThat(result, is(expect));
    }

    @Test
    public void whenFindExistItemThenTrackerFindByIdReturnedThatItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item expect = item2;
        Item result = tracker.findById(item2.getId());
        assertThat(result, is(expect));
    }

    @Test
    public void whenFindNotExistItemThenTrackerFindByIdReturnedNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item expect = null;
        Item result = tracker.findById("wrong Id");
        assertThat(result, is(expect));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenReplaceButThatIdNotExist() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        List<Item> result = tracker.findAll();
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findByName(bugWithDesc.getName()), is(result));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}