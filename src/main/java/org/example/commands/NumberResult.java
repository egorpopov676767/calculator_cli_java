package org.example.commands;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class NumberResult extends CommandResult {

    @Nonnull
    private BigDecimal result;

    public NumberResult(@Nonnull BigDecimal result) {this.result = result;}

    @Nonnull
    public BigDecimal getResult() {
        return result;
    }

    @Override
    public String toString() {return result.toString();}

}