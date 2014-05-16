package io.github.furikuri.cc.csv;

import io.github.furikuri.cc.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Core {

    private int currentPage = 0;
    private int itemsPerPage = 0;
    private List<String> originalLines;

    private Function<String, List<String>> resource;
    private Consumer<List<String>> consumer;

    public Core(Function<String, List<String>> resource,
                Consumer<List<String>> consumer) {
        this.resource = resource;
        this.consumer = consumer;
    }

    public void doCommand(Command command) {
        switch (command) {
            case FIRST:
                first();
                break;
            case NEXT:
                next();
                break;
            case LAST:
                last();
                break;
            case PREV:
                prev();
                break;
        }
    }

    public void start(String... args) {
        itemsPerPage = Integer.valueOf(args[1]);
        originalLines = resource.apply(args[0]);
        showPage();
    }

    public void first() {
        currentPage = 0;
        showPage();
    }

    public void next() {
        currentPage++;
        int lastPage = getLastPage();
        if (currentPage > lastPage) {
            currentPage = lastPage;
        }
        showPage();
    }

    public void prev() {
        currentPage--;
        if (currentPage < 0) {
            currentPage = 0;
        }
        showPage();
    }

    public void last() {
        int lastPage = getLastPage();
        currentPage = lastPage;
        showPage();
    }

    private int getLastPage() {
        int rows = originalLines.size() - 1;
        return rows / itemsPerPage;
    }

    private void showPage() {
        List<String> lines = new ArrayList<>(originalLines);
        String headerLine = lines.get(0);
        lines.remove(0);
        List<String> content = page(lines, itemsPerPage, currentPage);
        content.add(0, headerLine);
        List<String> formattedLines = format(content);
        consumer.accept(formattedLines);
    }

    private List<String> page(List<String> lines, int limit, int pageNumber) {
        List<String> l = new ArrayList<>();
        return lines.stream().skip(pageNumber * limit).limit(limit).collect(Collectors.toList());
    }

    private List<String> format(List<String> lines) {
        Grid grid = new Grid();
        boolean isFirstLine = true;
        for (String line : lines) {
            if (isFirstLine) {
                grid.setHeaders(split(line));
                isFirstLine = false;
            } else {
                grid.addRow(split(line));
            }
        }
        return createLines(grid);
    }

    private List<String> createLines(Grid grid) {
        List<Integer> columnsWidth = new ArrayList<>();
        for (int i = 0; i < grid.getColumnsCount(); i++) {
            columnsWidth.add(grid.getWidth(i));
        }

        List<String> lines = new ArrayList<>();

        String line = "";
        String separator = "";
        for (int i = 0; i < grid.getColumnsCount(); i++) {
            line += StringUtil.fillWithSpaces(grid.getHeaders().get(i), columnsWidth.get(i)) + " | ";
            separator += StringUtil.fillWithMinus("", columnsWidth.get(i)) + "-+-";
        }
        lines.add(line);
        lines.add(separator);
        for (List<String> row : grid.getRows()) {
            line = "";
            for (int i = 0; i < grid.getColumnsCount(); i++) {
                line += StringUtil.fillWithSpaces(row.get(i), columnsWidth.get(i)) + " | ";
            }
            lines.add(line);
        }

        return lines;
    }

    private List<String> split(String line) {
        return Arrays.asList(line.split(";"));
    }

}
