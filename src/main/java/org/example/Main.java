package org.example;

import org.example.commands.Command;
import org.example.commands.commands.AddCommand;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Command> commands = new ArrayList<>();

    public static void main(String[] args) {
        initialize();

        for (var c : commands) {
            var o = c.tryExecute(args);
            o.ifPresent(System.out::println);
        }
    }

    public static void initialize() {
        var reflections = new Reflections("org.example");
        var subTypes = reflections.getSubTypesOf(Command.class);
        for (var subType : subTypes) {
            try {
                var c = subType.getDeclaredConstructor();
                commands.add(c.newInstance());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}