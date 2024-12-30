package org.example;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

import static org.example.commands.CommandExecutor.tryExecute;

public class Main {

    public static InputStream inputStream = System.in;
    public static PrintStream outputStream = System.out;

    public static void main(String[] args) {
        if (args.length != 0) {
            var result = tryExecute(args);
            outputStream.println(result);
        } else {
            var scanner = new Scanner(inputStream);
            String inputLine;
            while (scanner.hasNextLine() && !Objects.equals(inputLine = scanner.nextLine(), "quit")) {
                var result = tryExecute(inputLine);
                outputStream.println(result);
            }
        }
    }

}