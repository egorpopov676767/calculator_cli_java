package org.example.commands.binary.commands;

import org.example.commands.Command;
import org.example.commands.binary.BinaryOperationCommand;

import java.math.BigDecimal;
import java.util.Optional;

public class MultiplyCommand extends BinaryOperationCommand {

    @Override
    public String getName() {
        return "mul";
    }

    @Override
    public Optional<BigDecimal> operation(BigDecimal a, BigDecimal b) {
        return Optional.of(a.multiply(b));
    }

}
