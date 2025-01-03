package org.example.operations;

import org.example.commands.CommandExecutor;
import org.example.commands.CommandResult;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Статический класс, извлекающий список доступных операций через рефлексию
 */
public class OperationsList {

    public static List<Operation> operationsList;

    static {
        var reflections = new Reflections("org.example");
        ArrayList<Class<? extends Operation>> operationTypes = new ArrayList<>();
        for (var c : reflections.getSubTypesOf(Operation.class)) {
            operationTypes.addAll(
                    reflections.getSubTypesOf(c));
        }

        var operations = new ArrayList<Operation>();
        for (var operationType : operationTypes) {
            try {
                var constructor = operationType.getDeclaredConstructor();
                operations.add(constructor.newInstance());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }

        operationsList = Collections.unmodifiableList(operations);
    }

    private OperationsList() {
    }

}
