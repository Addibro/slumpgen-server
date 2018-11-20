package com.web.json;

import java.util.Collection;
import java.util.Map;
import java.util.StringJoiner;

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
        return newline() + space() + space() + quote() + key + quote() + ": " + ((value.indexOf("{") == -1) ? quote() + value + quote() : value);
    }

    static String jsonAttribute(String key, int value) {
        return newline() + space() + space() + quote() + key + quote() + ": " + value;
    }

    static StringJoiner getStringJoiner() {
        return new StringJoiner(",", space() + "{", newline() + space() + "}");
    }
}