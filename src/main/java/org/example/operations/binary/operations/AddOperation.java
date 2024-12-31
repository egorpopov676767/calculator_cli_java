package org.example.operations.binary.operations;

import org.example.commands.CommandResult;
import org.example.commands.NumberResult;
import org.example.operations.binary.BinaryCumulativeOperation;
import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class AddOperation extends BinaryCumulativeOperation {

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "суммирует числа";
    }

    @Override
    public CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b) {
        return new NumberResult(
                a.add(b));
    }

}
