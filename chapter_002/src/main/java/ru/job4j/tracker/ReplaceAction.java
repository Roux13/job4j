package ru.job4j.tracker;

import java.util.function.Consumer;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("=== Replace the Item ===");
        String id = input.askStr("Enter id of Item for replacing: ");
        String newName = input.askStr("Enter new Item name: ");
        if (tracker.replace(id, new Item(newName))) {
            output.accept("The Item with id: \"" +  id + "\" is replaced.");
        } else {
            output.accept("The Item with id \"" + id + "\" is not found.");
        }
    }
}
