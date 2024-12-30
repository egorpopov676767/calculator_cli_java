package org.example.operations.binary.operations;

import org.example.commands.CommandResult;
import org.example.operations.binary.BinaryOperation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class SubtractOperation extends BinaryOperation {

    @Override
    public String getName() {
        return "sub";
    }

    @Override
    public String getDescription() {
        return "вычитает из первого числа все последующие";
    }

    @Override
    public CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b) {
        return new CommandResult(
                a.subtract(b));
    }

}
