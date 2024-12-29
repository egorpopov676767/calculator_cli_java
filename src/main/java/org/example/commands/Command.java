package org.example.commands;

import java.math.BigDecimal;
import java.util.Optional;

public abstract class Command {

    public abstract String getName();

    public boolean checkNamesMatch(String[] args) {
        var name = getName();
        return args.length != 0 && (args[0].equals(name) || args[0].equals('-' + name));
    }

    public abstract Optional<BigDecimal> tryExecute(String[] args);
}
