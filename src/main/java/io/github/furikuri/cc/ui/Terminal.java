package io.github.furikuri.cc.ui;

import io.github.furikuri.cc.Command;

import java.util.Scanner;
import java.util.function.Consumer;

public class Terminal {
    public void startReadLoop(Consumer<Command> commandConsumer) {
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
