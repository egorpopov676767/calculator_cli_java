package org.example.commands;

import javax.annotation.Nonnull;

import static java.text.MessageFormat.format;

public class ExceptionResult extends CommandResult {

    @Nonnull
    private Throwable exception;

    public ExceptionResult(@Nonnull String exceptionMessage) {
        this.exception = new Exception(exceptionMessage);
    }

    public ExceptionResult(@Nonnull Throwable exception) {
        this.exception = exception;
    }

    @Nonnull
    public Throwable getException() {
        return exception;
    }

    @Override
    public String toString() {
        return format("Ошибка: {0}", exception.getMessage());
    }

}
