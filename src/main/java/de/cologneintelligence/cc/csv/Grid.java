package de.cologneintelligence.cc.csv;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<String> header = new ArrayList<>();

    private List<List<String>> lines = new ArrayList<>();


    public void setHeader(List<String> header) {
        this.header = header;
    }

    public void addLine(List<String> line) {
        lines.add(line);
    }

    public int getColumnsCount() {
        return header.size();
    }

    public int getMaxWidth(int columnNumber) {
        int max = header.get(columnNumber).length();
        for (List<String> line : lines) {
            String lineCell = line.get(columnNumber);
            if (lineCell.length() > max) {
                max = lineCell.length();
            }
        }
        return max;
    }

    public List<String> getHeader() {
        return header;
    }

    public List<List<String>> getLines() {
        return lines;
    }
}
