package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private static final String SEPARATOR = "==============================";

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
                int select = input.askInt(String.format("Enter a number from 0 to %d: ", actions.size() - 1), actions.size());
                UserAction action = actions.get(select);
                run = action.execute(input, tracker);
            System.out.println(SEPARATOR);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i).name());
        }
    }


    public static void main(String[] args) {
        Input validateInput = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        );
        new StartUI().init(validateInput, tracker, actions);
    }

}
