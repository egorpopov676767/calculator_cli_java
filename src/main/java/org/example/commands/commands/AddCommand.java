package org.example.commands.commands;

import org.example.commands.Command;

import java.math.BigDecimal;
import java.util.Optional;

public class AddCommand extends Command {

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public Optional<BigDecimal> tryExecute(String[] args) {
        if(checkNamesMatch(args)) {
            return Optional.of(new BigDecimal(44443));
        }
        return Optional.empty();
    }
}
