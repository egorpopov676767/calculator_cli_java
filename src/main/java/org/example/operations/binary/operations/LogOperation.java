package org.example.operations.binary.operations;

import org.example.commands.CommandResult;
import org.example.commands.NumberResult;
import org.example.operations.binary.BinaryNonCumulativeOperation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class LogOperation extends BinaryNonCumulativeOperation {
    @Override
    public CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b) {
        return new  NumberResult( BigDecimal.valueOf(Math.log(b.doubleValue()) / Math.log(a.doubleValue())));
    }

    @Override
    public String getName() {
        return "log";
    }

    @Override
    public String getDescription() {
        return "логарифм числа b по основанию a";
    }
}
