package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Search an Item by Id ===");
        String id = input.askStr("Enter id of Item for searching: ");
        Item find = tracker.findById(id);
        if (find != null) {
            System.out.println(find.getId() + " " + find.getName());
        }
        return true;
    }
}
