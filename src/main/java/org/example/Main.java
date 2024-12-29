package org.example;

import static org.example.commands.CommandsList.tryExecute;

public class Main {

    public static void main(String[] args) {
        var result = tryExecute(args);
        System.out.println(
                result.isPresent() ? result.get() : result.getException().getMessage());
    }

}