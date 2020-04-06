package ru.job4j.tracker;

import java.util.function.Consumer;

public class StubAction implements UserAction {
    private boolean call = false;
    private Callback callback;

    public StubAction(Callback callback) {
        this.callback = callback;
    }

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        callback.shutdown();
        call = true;
    }

    public boolean isCall() {
        return this.call;
    }
}
