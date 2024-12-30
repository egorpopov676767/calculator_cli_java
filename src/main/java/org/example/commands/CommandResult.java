package org.example.commands;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static java.text.MessageFormat.format;

public class CommandResult<T> {

    @Nullable
    private T result;

    @Nullable
    private Throwable exception;

    public CommandResult(@Nonnull T result) {this.result = result;}

    public CommandResult(@Nonnull Throwable exception) {this.exception = exception;}

    public boolean isPresent() {
        return result != null;
    }

    @Nullable
    public Object get() {
        return isPresent() ? result :
                format("Ошибка: {0}", exception.getMessage());
    }

    @Nullable
    public T getResult() {
        return result;
    }

    @Nullable
    public Throwable getException() {
        return exception;
    }

    public void print(){
        System.out.println(
                isPresent() ? result :
                        format("Ошибка: {0}", exception.getMessage()));
    }

}
