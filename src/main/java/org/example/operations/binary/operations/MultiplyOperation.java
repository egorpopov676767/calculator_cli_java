package org.example.operations.binary.operations;

import org.example.commands.CommandResult;
import org.example.commands.NumberResult;
import org.example.operations.binary.BinaryOperation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class MultiplyOperation extends BinaryOperation {

    @Override
    public String getName() {
        return "mul";
    }

    @Override
    public String getDescription() {
        return "перемножает числа";
    }

    @Override
    public CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b) {
        return new NumberResult(
                a.multiply(b));
    }

}
