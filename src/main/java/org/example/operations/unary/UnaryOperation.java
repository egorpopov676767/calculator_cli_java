package org.example.operations.unary;

import org.example.commands.CommandResult;
import org.example.operations.Operation;
import javax.annotation.Nonnull;
import java.math.BigDecimal;

public abstract class UnaryOperation extends Operation {

    public abstract CommandResult operation(@Nonnull BigDecimal a);

}
