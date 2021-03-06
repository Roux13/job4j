package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("=== Delete the Item ===");
        String id = input.askStr("Enter id of Item for deleting: ");
        if (tracker.delete(id)) {
            System.out.println("The Item with id: \"" +  id + "\" is deleted.");
        } else {
            System.out.println("The Item with id \"" + id + "\" is not found.");
        }
    }
}
