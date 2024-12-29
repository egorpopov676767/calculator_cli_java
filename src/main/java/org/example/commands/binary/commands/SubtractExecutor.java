package org.example.commands.binary.commands;

import org.example.commands.CommandResult;
import org.example.commands.binary.BinaryOperationExecutor;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Optional;

public class SubtractExecutor extends BinaryOperationExecutor {

    @Override
    public String getName() {
        return "sub";
    }

    @Override
    public CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b) {
        return new CommandResult(
                a.subtract(b));
    }

}
