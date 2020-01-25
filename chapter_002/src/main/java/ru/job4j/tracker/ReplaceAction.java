package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Replace the Item ===");
        String id = input.askStr("Enter id of Item for replacing: ");
        String newName = input.askStr("Enter new Item name: ");
        if (tracker.replace(id, new Item(newName))) {
            System.out.println("The Item with id: \"" +  id + "\" is replaced.");
        } else {
            System.out.println("The Item with id \"" + id + "\" is not found.");
        }
        return true;
    }
}
