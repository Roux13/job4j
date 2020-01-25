package ru.job4j.tracker;

public class StartUI {
    private static final String SEPARATOR = "==============================";

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            try {
                int select = input.askInt(String.format("Select (enter a number from 0 to %d): ", actions.length - 1));
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input.");
            }
            System.out.println(SEPARATOR);
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Input input, Tracker tracker) {
        System.out.println("=== The list of all Items ====");
        Item[] allItems = tracker.findAll();
        for (Item item : allItems) {
            System.out.println(item.getId() + " " + item.getName());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit the Item ===");
        String id = input.askStr("Enter id of Item for editing: ");
        String newName = input.askStr("Enter new Item name: ");
        if (tracker.replace(id, new Item(newName))) {
            System.out.println("The Item with id: \"" +  id + "\" is edited.");
        } else {
            System.out.println("The Item with id \"" + id + "\" is not found.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete the Item ===");
        String id = input.askStr("Enter id of Item for deleting: ");
        if (tracker.delete(id)) {
            System.out.println("The Item with id: \"" +  id + "\" is deleted.");
        } else {
            System.out.println("The Item with id \"" + id + "\" is not found.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Search an Item by Id ===");
        String id = input.askStr("Enter id of Item for searching: ");
        Item find = tracker.findById(id);
        if (find != null) {
            System.out.println(find.getId() + " " + find.getName());
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Search Items by name ===");
        String key = input.askStr("Enter name of Item for searching: ");
        Item[] findItems = tracker.findByName(key);
        for (Item item : findItems) {
            System.out.println(item.getId() + " " + item.getName());
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction(),
        };
        new StartUI().init(input, tracker, actions);
    }

}
