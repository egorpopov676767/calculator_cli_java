package org.example.commands;

import org.example.operations.binary.BinaryOperation;
import org.example.operations.other.OtherOperation;
import org.example.operations.other.operations.HelpOperation;

import java.math.BigDecimal;

public abstract class CommandExecutor {

    public static CommandResult tryExecute(String string) {
        return tryExecute(string.trim().split("\\s+"));
    }

    public static CommandResult tryExecute(String[] args) {
        try {
            return tryExecute(new Command(args));
        } catch (Exception e) {
            return new ExceptionResult(e);
        }
    }

    public static CommandResult tryExecute(
            Command command) {
        var operation = command.operation;
        var condition = command.condition;
        var values = command.values;
        switch (operation) {
            case BinaryOperation binaryOperation:
                var res = values[0];
                for (var i = 1; i < values.length; i++) {
                    if (condition.test(values[i])) {
                        var o = binaryOperation.operation(res, values[i]);
                        switch (o){
                            case NumberResult numberResult:
                                res = numberResult.getResult();
                                break;
                            case ExceptionResult exceptionResult:
                                return exceptionResult;
                            default:
                                throw new IllegalStateException();
                        }
                    }
                }
                return new NumberResult(res);
            case OtherOperation otherOperation:
                switch (otherOperation) {
                    case HelpOperation helpOperation:
                        return new StringResult(helpOperation.getHelp());
                    default:
                        throw new IllegalStateException();
                }
            default:
                return new ExceptionResult(new Exception());
        }
    }

}
