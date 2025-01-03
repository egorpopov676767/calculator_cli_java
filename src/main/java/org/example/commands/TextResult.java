package org.example.commands;

import javax.annotation.Nonnull;

/**
 * Базовый абстрактный класс, обозначающий текст, полученный в результате выполнения команды
 */
public class TextResult extends CommandResult {

    @Nonnull
    private String result;

    public TextResult(@Nonnull String result) {this.result = result;}

    @Nonnull
    public String getResult() {
        return result;
    }

    @Override
    public String toString() {return result;}

}
