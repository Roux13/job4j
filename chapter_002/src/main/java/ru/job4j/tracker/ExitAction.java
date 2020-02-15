package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("=== Exit from the program. ===");
        return false;
    }
}
