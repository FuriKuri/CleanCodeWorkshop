package io.github.furikuri.cc.ui;

import java.util.List;

public class UI {
    public void print(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }

        System.out.println();
        System.out.println("F)irst N)ext P)rev L)ast E(x)it");
    }
}
