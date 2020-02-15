package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {

    public static void main(String[] args) {
        Consumer<String> output = System.out::println;
        Input validateInput = new ValidateInput(new ConsoleInput(), output);
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
        new StartUI(validateInput, tracker, output).init(actions);
    }
}
