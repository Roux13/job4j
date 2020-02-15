package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class StartUI {

    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    private static final String SEPARATOR = "==============================";

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init(List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
                int select = this.input.askInt(
                        String.format("Enter a number from 0 to %d: ", actions.size() - 1), actions.size()
                );
                UserAction action = actions.get(select);
                run = action.execute(this.input, this.tracker, this.output);
            this.output.accept(SEPARATOR);
        }
    }

    private void showMenu(List<UserAction> actions) {
        this.output.accept("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            this.output.accept(i + ". " + actions.get(i).name());
        }
    }

}
