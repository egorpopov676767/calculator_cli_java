package org.example.commands;

import org.example.operations.binary.BinaryCumulativeOperation;
import org.example.operations.binary.BinaryNonCumulativeOperation;
import org.example.operations.other.OtherOperation;
import org.example.operations.other.operations.HelpOperation;
import org.example.operations.unary.UnaryOperation;

/**
 * Статический класс, принимающий команду и исполняющий её
 */
public class CommandExecutor {

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
        var values = command.values;
        switch (operation) {
            case UnaryOperation unaryOperation:
                var value = values[0];
                return unaryOperation.operation(value);
            case BinaryCumulativeOperation binaryCumulativeOperation:
                var res = values[0];
                for (var i = 1; i < values.length; i++) {
                    var o = binaryCumulativeOperation.operation(res, values[i]);
                    switch (o) {
                        case NumberResult numberResult:
                            res = numberResult.getResult();
                            break;
                        case ExceptionResult exceptionResult:
                            return exceptionResult;
                        default:
                            throw new IllegalStateException();
                    }
                }
                return new NumberResult(res);
            case BinaryNonCumulativeOperation binaryNonCumulativeOperation:
                return binaryNonCumulativeOperation.operation(values[0], values[1]);
            case OtherOperation otherOperation:
                switch (otherOperation) {
                    case HelpOperation helpOperation:
                        return new TextResult(helpOperation.getHelp());
                    default:
                        throw new IllegalStateException();
                }
            default:
                throw new IllegalStateException();
        }
    }

    private CommandExecutor() {
    }

}
