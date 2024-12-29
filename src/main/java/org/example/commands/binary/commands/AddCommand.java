package org.example.commands.binary.commands;

import org.example.commands.Command;
import org.example.commands.binary.BinaryOperationCommand;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Predicate;

public class AddCommand extends BinaryOperationCommand {

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public Optional<BigDecimal> operation(BigDecimal a, BigDecimal b) {
        return Optional.of(a.add(b)) ;
    }
}