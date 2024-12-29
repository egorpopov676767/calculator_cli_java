package org.example.commands.binary.commands;

import org.example.commands.CommandResult;
import org.example.commands.binary.BinaryOperationExecutor;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Optional;

public class DivideExecutor extends BinaryOperationExecutor {

    @Override
    public String getName() {
        return "div";
    }

    @Override
    public CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b) {
        try {
            return new CommandResult(
                    a.divide(b));
        } catch (ArithmeticException e) {
            return new CommandResult(
                    new Exception("Ошибка: деление на ноль"));
        }
    }

}
