package org.example.commands;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Predicate;

public abstract class CommandExecutor {

    public abstract String getName();

    public boolean checkNamesMatch(@Nonnull String[] args) {
        var name = getName();
        return args.length != 0 && (args[0].equals(name) || args[0].equals('-' + name));
    }

    public CommandResult tryExecute(@Nonnull String[] args) {
        if (checkNamesMatch(args)) {
            return tryExecute2(Arrays.copyOfRange(args, 1, args.length));
        }
        return new CommandResult(new Exception("invalid name"));
    }

    public CommandResult tryExecute2(@Nonnull String[] args) {
        if (args.length != 0 && (args[0].equals("odd"))) {
            return tryExecute3((x) -> !(x.toBigInteger().testBit(0)), Arrays.copyOfRange(args, 1, args.length));
        }
        if (args.length != 0 && (args[0].equals("even"))) {
            return tryExecute3((x) -> (x.toBigInteger().testBit(0)), Arrays.copyOfRange(args, 1, args.length));
        }
        return tryExecute3((_) -> true, args);
    }

    public abstract CommandResult tryExecute3(
            @Nonnull Predicate<BigDecimal> condition, @Nonnull String[] args);
}
