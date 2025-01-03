package org.example.commands;

import org.example.operations.Operation;
import org.example.operations.binary.BinaryCumulativeOperation;
import org.example.operations.binary.BinaryNonCumulativeOperation;
import org.example.operations.unary.UnaryOperation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

import static java.text.MessageFormat.format;
import static org.example.operations.OperationsList.operationsList;

/**
 * Базовый абстрактный класс, обозначающий команду
 */
public class Command {

    @Nonnull
    Operation operation;

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

        var valuesCount = args.length - 1;
        switch (operation) {
            case UnaryOperation _ when valuesCount != 1 -> throw new Exception("должен быть ровно один аргумент");
            case BinaryCumulativeOperation _ when valuesCount < 1 ->
                    throw new Exception("должен быть хотя бы один аргумент");
            case BinaryNonCumulativeOperation _ when valuesCount != 2 ->
                    throw new Exception("должно быть ровно два аргумента");
            default -> {
            }
        }
        var values = new BigDecimal[valuesCount];

        for (var i = 0; i < valuesCount; i++) {
            try {
                values[i] = new BigDecimal(args[i + 1]);
            } catch (NumberFormatException e) {
                throw new Exception(
                        format("некорректное значение: {0}", args[i + 1]));
            }
        }
        this.values = values;
    }

}
