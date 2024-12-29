package org.example.commands;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandsList {

    public static List<CommandExecutor> commandsList;

    static {
        var reflections = new Reflections("org.example");
        ArrayList<Class<? extends CommandExecutor>> commandTypes = new ArrayList<>();
        for (var c : reflections.getSubTypesOf(CommandExecutor.class)) {
            commandTypes.addAll(
                    reflections.getSubTypesOf(c));
        }

        List<CommandExecutor> commands = new ArrayList<>();
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

    public static CommandResult tryExecute(String[] args) {
        for (var command : commandsList) {
            if (command.checkNamesMatch(args)) {
                return command.tryExecute(args);
            }
        }
        return new CommandResult(new Exception("не найдено"));
    }

}
