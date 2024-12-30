package org.example.commands;

import org.example.operations.binary.BinaryOperation;
import org.example.operations.other.OtherOperation;
import org.example.operations.other.operations.HelpOperation;

public abstract class CommandExecutor {

    public static CommandResult tryExecute(String string) {
        return tryExecute(string.split("\\s+"));
    }

    public static CommandResult tryExecute(String[] args) {
        try {
            return tryExecute(new Command(args));
        } catch (Exception e) {
            return new CommandResult<>(e);
        }
    }

    public static CommandResult tryExecute(
            Command command) {
        var operation = command.operation;
        var condition = command.condition;
        var values = command.values;
        if (operation instanceof BinaryOperation binaryOperation) {
            var res = values[0];
            for (var i = 1; i < values.length; i++) {
                if (condition.test(values[i])) {
                    var o = binaryOperation.operation(res, values[i]);
                    if (o.isPresent()) {
                        res = o.getResult();
                    } else {
                        return o;
                    }
                }
            }
            return new CommandResult<>(res);
        } else if (operation instanceof OtherOperation otherOperation) {
            if (otherOperation instanceof HelpOperation helpOperation) {
                return new CommandResult<>(helpOperation.getHelp());
            }
        }
        return new CommandResult<>(new Exception());
    }

}
