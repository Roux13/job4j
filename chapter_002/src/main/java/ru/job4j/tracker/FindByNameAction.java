package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("=== Search Items by name ===");
        String key = input.askStr("Enter name of Item for searching: ");
        List<Item> findItems = tracker.findByName(key);
        for (Item item : findItems) {
            output.accept(item.getId() + " " + item.getName());
        }
        return true;
    }
}
