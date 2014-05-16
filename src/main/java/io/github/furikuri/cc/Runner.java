package io.github.furikuri.cc;

import io.github.furikuri.cc.csv.Core;
import io.github.furikuri.cc.file.FileReader;
import io.github.furikuri.cc.ui.Terminal;
import io.github.furikuri.cc.ui.UI;

public class Runner {
    public static void main(String[] args) {
        Core core = new Core(new FileReader()::readLines, new UI()::print);
        core.start(args);
        new Terminal().startReadLoop(core::doCommand);
    }
}
