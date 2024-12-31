package org.example.operations.binary;


import org.example.commands.CommandResult;
import org.example.operations.Operation;
import javax.annotation.Nonnull;
import java.math.BigDecimal;

public abstract class BinaryNonCumulativeOperation extends Operation {

    public abstract CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b);

}
