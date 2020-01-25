package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Search Items by name ===");
        String key = input.askStr("Enter name of Item for searching: ");
        Item[] findItems = tracker.findByName(key);
        for (Item item : findItems) {
            System.out.println(item.getId() + " " + item.getName());
        }
        return true;
    }
}
