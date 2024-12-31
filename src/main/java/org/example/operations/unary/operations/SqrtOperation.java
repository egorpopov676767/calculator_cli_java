package org.example.operations.unary.operations;

import org.example.commands.CommandResult;
import org.example.commands.ExceptionResult;
import org.example.commands.NumberResult;
import org.example.operations.unary.UnaryOperation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.MathContext;

public class SqrtOperation extends UnaryOperation {

    @Override
    public String getName() {
        return "sqrt";
    }

    @Override
    public String getDescription() {
        return "квадратный корень числа";
    }

    @Override
    public CommandResult operation(@Nonnull BigDecimal a) {
        try {
            return new NumberResult(
                    a.sqrt(new MathContext(9)));
        } catch (Exception e) {
            return new ExceptionResult("число должно быть положительным");
        }
    }

}
