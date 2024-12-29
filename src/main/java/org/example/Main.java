package org.example;

import static org.example.commands.CommandsList.tryExecute;

public class Main {

    public static void main(String[] args) {
        var o = tryExecute(args);
        o.ifPresent(System.out::println);
    }

}