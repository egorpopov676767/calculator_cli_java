package org.example.operations.binary.operations;

import org.example.commands.CommandResult;
import org.example.operations.binary.BinaryOperation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class DivideOperation extends BinaryOperation {

    @Override
    public String getName() {
        return "div";
    }

    @Override
    public String getDescription() {
        return "делит на первое число все последующие";
    }

    @Override
    public CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b) {
        try {
            return new CommandResult(
                    a.divide(b, 9, BigDecimal.ROUND_HALF_UP));
        } catch (ArithmeticException e) {
            return new CommandResult(
                    new Exception("деление на ноль"));
        }
    }

}
