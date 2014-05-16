package io.github.furikuri.cc.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileReader {
    public List<String> readLines(String fileName) {
        try {
            return FileUtils.readLines(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
