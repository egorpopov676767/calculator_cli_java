package org.example.operations.binary;

import org.example.commands.CommandResult;
import org.example.commands.NumberResult;
import org.example.operations.Operation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public abstract class BinaryOperation extends Operation {

    public abstract String getName();

    public abstract CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b);

}
