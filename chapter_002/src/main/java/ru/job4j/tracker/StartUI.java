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
