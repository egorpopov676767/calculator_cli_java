package org.example.commands;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class Command {

    public abstract String getName();

    public boolean checkNamesMatch(String[] args) {
        var name = getName();
        return args.length != 0 && (args[0].equals(name) || args[0].equals('-' + name));
    }

    public Optional<BigDecimal> tryExecute(String[] args) {
        if (checkNamesMatch(args)) {
            return tryExecute2(Arrays.copyOfRange(args, 1, args.length));
        }
        return Optional.empty();
    }

    public Optional<BigDecimal> tryExecute2(String[] args) {
        if (args.length != 0 && (args[0].equals("odd"))) {
            return tryExecute3((x) -> !(x.toBigInteger().testBit(0)), Arrays.copyOfRange(args, 1, args.length));
        }
        if (args.length != 0 && (args[0].equals("even"))) {
            return tryExecute3((x) -> (x.toBigInteger().testBit(0)), Arrays.copyOfRange(args, 1, args.length));
        }
        return tryExecute3((_) -> true, args);
    }

    public abstract Optional<BigDecimal> tryExecute3(Predicate<BigDecimal> condition, String[] args);
}
