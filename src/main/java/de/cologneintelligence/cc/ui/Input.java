package de.cologneintelligence.cc.ui;

import de.cologneintelligence.cc.Command;

import java.util.Scanner;
import java.util.function.Consumer;

public class Input {
    public void startReadLoop(String[] args, Consumer<String[]> start, Consumer<Command> commandConsumer) {
        start.accept(args);
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toLowerCase();
        while (!input.equals("e")) {
            switch (input) {
                case "f":
                    commandConsumer.accept(Command.FIRST);
                    break;
                case "n":
                    commandConsumer.accept(Command.NEXT);
                    break;
                case "p":
                    commandConsumer.accept(Command.PREV);
                    break;
                case "l":
                    commandConsumer.accept(Command.LAST);
                    break;
            }
            input = in.nextLine().toLowerCase();
        }
    }
}
