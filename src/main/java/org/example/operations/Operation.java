package org.example.operations;

import javax.annotation.Nonnull;

public abstract class Operation {

    public abstract String getName();

    public abstract String getDescription();

    public boolean checkNamesMatch(@Nonnull String arg) {
        var name = getName();
        return arg.equals(name) || arg.equals('-' + name);
    }

}
