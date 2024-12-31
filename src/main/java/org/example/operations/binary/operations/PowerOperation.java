package org.example.operations.binary.operations;

import org.example.commands.CommandResult;
import org.example.commands.ExceptionResult;
import org.example.commands.NumberResult;
import org.example.operations.binary.BinaryNonCumulativeOperation;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class PowerOperation extends BinaryNonCumulativeOperation {

    @Override
    public String getName() {
        return "pow";
    }

    @Override
    public String getDescription() {
        return "возводит число в степень";
    }

    @Override
    public CommandResult operation(@Nonnull BigDecimal a, @Nonnull BigDecimal b) {
        try {
            if (b.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO) &&
                    0 <= b.intValue() && b.intValue() <= 999999999) {
                return new NumberResult(
                        a.pow(b.intValue()));
            } else {
                return new NumberResult(
                        BigDecimal.valueOf(
                                Math.pow(a.doubleValue(), b.doubleValue())));
            }
        } catch (Exception e) {
            return new ExceptionResult("ошибка возведения в степень");
        }
    }

}
