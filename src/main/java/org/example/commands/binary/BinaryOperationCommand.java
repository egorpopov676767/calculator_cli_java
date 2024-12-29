package org.example.commands.binary;

import org.example.commands.Command;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class BinaryOperationCommand extends Command {

    public abstract Optional<BigDecimal> operation(BigDecimal a, BigDecimal b);

    public Optional<BigDecimal> tryExecute3(Predicate<BigDecimal> condition, String[] args) {
        var res = new BigDecimal(args[0]);
        for (var i = 1; i < args.length; i++) {
            BigDecimal value;
            try {
                value = new BigDecimal(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректное значение: " + args[i]);
                return Optional.empty();
            }
            if (condition.test(value)) {
                var o = operation(res, value);
                if (o.isPresent()) {
                    res = o.get();
                } else {
                    return Optional.empty();
                }
            }
        }
        return Optional.of(res);
    }
}
