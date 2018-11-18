package com.web.json;

public interface Formatter<T> {
    String format();
    String jsonObj(T type);

    static String quote() {
        return "\"";
    }

    static String newline() {
        return "\n";
    }
}