package de.cologneintelligence.cc.csv;

public class StringUtil {
    public static String fillWithSpaces(String string, int length) {
        while (string.length() < length) {
            string = string + " ";
        }
        return string;
    }

    public static String fillWithMinus(String string, int length) {
        while (string.length() < length) {
            string = string + "-";
        }
        return string;
    }
}
