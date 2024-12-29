package org.example.commands.binary.commands;

import org.example.commands.Command;
import org.example.commands.binary.BinaryOperationCommand;

import java.math.BigDecimal;
import java.util.Optional;

public class DivideCommand extends BinaryOperationCommand {

    @Override
    public String getName() {
        return "div";
    }

    @Override
    public Optional<BigDecimal> operation(BigDecimal a, BigDecimal b) {
        try {
            return Optional.of(a.divide(b));
        }catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль");
            return Optional.empty();
        }
    }

}
