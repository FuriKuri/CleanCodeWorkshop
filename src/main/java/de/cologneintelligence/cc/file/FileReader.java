package de.cologneintelligence.cc.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileReader {
    public List<String> readLines(String fileName) {
        try {
            return FileUtils.readLines(new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
