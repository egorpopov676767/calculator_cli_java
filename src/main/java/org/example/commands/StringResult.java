package org.example.commands;

import javax.annotation.Nonnull;

public class StringResult extends CommandResult {

    @Nonnull
    private String result;

    public StringResult(@Nonnull String result) {this.result = result;}

    @Nonnull
    public String getResult() {
        return result;
    }

    @Override
    public String toString() {return result;}

}
