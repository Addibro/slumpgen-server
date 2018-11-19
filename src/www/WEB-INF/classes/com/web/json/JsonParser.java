package com.web.json;

import java.util.List;

public interface JsonParser<T> {
    List<T> parse(String json);
}