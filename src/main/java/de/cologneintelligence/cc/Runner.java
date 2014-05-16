package de.cologneintelligence.cc;


import de.cologneintelligence.cc.csv.Core;
import de.cologneintelligence.cc.file.FileReader;
import de.cologneintelligence.cc.ui.Input;
import de.cologneintelligence.cc.ui.Output;

public class Runner {
    public static void main(String[] args) {
        Core core = new Core(new FileReader()::readLines, new Output()::print);
        new Input().startReadLoop(args, core::start, core::doCommand);
    }
}
