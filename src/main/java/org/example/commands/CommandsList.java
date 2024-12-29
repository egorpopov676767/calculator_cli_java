package org.example.commands;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CommandsList {

    public static List<Command> commandsList;

    static {
        var reflections = new Reflections("org.example");
        ArrayList<Class<? extends Command>> commandTypes = new ArrayList<>();
        for (var c : reflections.getSubTypesOf(Command.class)) {
            commandTypes.addAll(
                    reflections.getSubTypesOf(c));
        }

        List<Command> commands = new ArrayList<>();
        for (var commandType : commandTypes) {
            try {
                var constructor = commandType.getDeclaredConstructor();
                commands.add(constructor.newInstance());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }

        commandsList = Collections.unmodifiableList(commands);
    }

    public static Optional<BigDecimal> tryExecute(String[] args) {
        for (var command : commandsList) {
            var result = command.tryExecute(args);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }

}
