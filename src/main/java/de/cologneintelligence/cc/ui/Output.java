package de.cologneintelligence.cc.ui;

import java.util.List;

public class Output {
    public void print(List<String> lines) {
        lines.forEach(System.out::println);
        System.out.println();
        System.out.println("F)irst N)ext P)rev L)ast E(x)it");
    }
}
