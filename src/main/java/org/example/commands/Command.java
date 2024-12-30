package org.example.commands;

import org.example.operations.Operation;
import org.example.operations.binary.BinaryOperation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.function.Predicate;

import static java.text.MessageFormat.format;
import static org.example.operations.OperationsList.operationsList;

public class Command {

    @Nonnull
    Operation operation;

    @Nullable
    Predicate<BigDecimal> condition;

    @Nonnull
    BigDecimal[] values;

    public Command(String string) throws Exception {
        this(string.trim().split("\\s+"));
    }

    public Command(String[] args) throws Exception {
        for (var operation : operationsList) {
            if (operation.checkNamesMatch(args[0])) {
                this.operation = operation;
            }
        }
        if (operation == null) {
            throw new Exception("команда не найдена");
        }

        var i = 1;
        if (args.length > 1 && (args[1].equals("odd"))) {
            condition = (x) -> !(x.toBigInteger().testBit(0));
            i++;
        } else if (args.length > 1 && (args[1].equals("even"))) {
            condition = (x) -> (x.toBigInteger().testBit(0));
            i++;
        } else {
            condition = (_) -> true;
        }

        var valuesCount = args.length - i;
        if(operation instanceof BinaryOperation && valuesCount < 1) {
            throw new Exception("должен быть хотя бы один аргумент");
        }
        var values = new BigDecimal[valuesCount];
        var i2 = 0;
        for (; i2<valuesCount; i++, i2++) {
            try {
                values[i2] = new BigDecimal(args[i]);
            } catch (NumberFormatException e) {
                throw new Exception(
                        format("некорректное значение: {0}", args[i]));
            }
        }
        this.values = values;
    }

}
