package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== The list of all Items ====");
        Item[] allItems = tracker.findAll();
        for (Item item : allItems) {
            System.out.println(item.getId() + " " + item.getName());
        }
        return true;
    }
}
