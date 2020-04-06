package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("=== The list of all Items ====");
        List<Item> allItems = tracker.findAll();
        for (Item item : allItems) {
            output.accept(item.getId() + " " + item.getName());
        }
    }
}
