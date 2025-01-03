package org.example.operations.binary;

import org.example.commands.CommandResult;
import org.example.operations.Operation;
import javax.annotation.Nonnull;
import java.math.BigDecimal;

/**
 * Операция на двух аргументах, выполняющаяся на наборе аргументов поочерёдно
 */
public abstract class BinaryCumulativeOperation extends Operation {

    public abstract CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b);

}
