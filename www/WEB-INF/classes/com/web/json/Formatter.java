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

    static String space() {
        return "    ";
    }

    static String jsonAttribute(String key, String value) {
        return space() + quote() + key + quote() + ": " + quote() + value + quote() + newline();
    }
}