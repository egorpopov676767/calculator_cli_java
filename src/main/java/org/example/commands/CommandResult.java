package org.example.commands;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;

public class CommandResult {

    @Nullable
    private BigDecimal result;

    @Nullable
    private Throwable exception;

    public CommandResult(@Nonnull BigDecimal result) {this.result = result;}

    public CommandResult(@Nonnull Throwable exception) {this.exception = exception;}

    public boolean isPresent() {
        return result != null;
    }

    @Nullable
    public BigDecimal get() {
        return result;
    }

    @Nullable
    public Throwable getException() {
        return exception;
    }

}
