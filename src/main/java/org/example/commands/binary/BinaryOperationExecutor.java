package org.example.commands.binary;

import org.example.commands.CommandExecutor;
import org.example.commands.CommandResult;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Predicate;

import static java.text.MessageFormat.format;

public abstract class BinaryOperationExecutor extends CommandExecutor {

    public abstract CommandResult operation(
            @Nonnull BigDecimal a, @Nonnull BigDecimal b);

    public CommandResult tryExecute3(
            @Nonnull Predicate<BigDecimal> condition, @Nonnull String[] args) {
        var res = new BigDecimal(args[0]);
        for (var i = 1; i < args.length; i++) {
            BigDecimal value;
            try {
                value = new BigDecimal(args[i]);
            } catch (NumberFormatException e) {
                return new CommandResult(
                        new Exception(
                                format("Ошибка: некорректное значение: {0}", args[i])));
            }
            if (condition.test(value)) {
                var o = operation(res, value);
                if (o.isPresent()) {
                    res = o.get();
                } else {
                    return o;
                }
            }
        }
        return new CommandResult(res);
    }
}
