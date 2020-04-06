package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("=== Search an Item by Id ===");
        String id = input.askStr("Enter id of Item for searching: ");
        Item find = tracker.findById(id);
        if (find != null) {
            output.accept(find.getId() + " " + find.getName());
        }
    }
}
