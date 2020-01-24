package ru.job4j.tracker;

public class StartUI {
    private static final String SEPARATOR = "==============================";

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            try {
                int select = input.askInt("Select (enter a number from 0 to 6): ");
                if (select == 0) {
                    StartUI.createItem(input, tracker);
                } else if (select == 1) {
                    StartUI.showItems(input, tracker);
                } else if (select == 2) {
                    StartUI.replaceItem(input, tracker);
                } else if (select == 3) {
                    StartUI.deleteItem(input, tracker);
                } else if (select == 4) {
                    StartUI.findItemById(input, tracker);
                } else if (select == 5) {
                    StartUI.findItemByName(input, tracker);
                } else if (select == 6) {
                    run = false;
                    System.out.println("=== Exit from the program. ===");
                }
            } catch (NumberFormatException e) {
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

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
