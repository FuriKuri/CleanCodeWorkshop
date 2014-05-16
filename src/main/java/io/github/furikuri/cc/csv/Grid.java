package io.github.furikuri.cc.csv;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<String> headers = new ArrayList<>();

    private List<List<String>> rows = new ArrayList<>();


    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public void addRow(List<String> row) {
        rows.add(row);
    }

    public int getColumnsCount() {
        return headers.size();
    }

    public int getWidth(int columnNumber) {
        int max = headers.get(columnNumber).length();
        for (List<String> row : rows) {
            String rowCell = row.get(columnNumber);
            if (rowCell.length() > max) {
                max = rowCell.length();
            }
        }
        return max;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }
}
