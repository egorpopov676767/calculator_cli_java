package org.example.operations.binary.operations;

import org.example.commands.CommandResult;
import org.example.commands.ExceptionResult;
import org.example.commands.NumberResult;
import org.example.operations.binary.BinaryCumulativeOperation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class DivideOperation extends BinaryCumulativeOperation {

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
            return new NumberResult(
                    a.divide(b, 9, BigDecimal.ROUND_HALF_UP));
        } catch (ArithmeticException e) {
            return new ExceptionResult(
                    new Exception("деление на ноль"));
        }
    }

}
