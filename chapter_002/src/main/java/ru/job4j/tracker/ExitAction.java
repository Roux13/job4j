package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitAction implements UserAction {

    private Callback callback;

    public ExitAction(Callback callback) {
        this.callback = callback;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("=== Exit from the program. ===");
        callback.shutdown();
    }
}
