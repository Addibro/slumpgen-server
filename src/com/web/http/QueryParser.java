package com.web.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *  //TODO
 */
public class QueryParser {

    private QueryParser() {}

    public static Map<String, String> parse(String querystring) throws IllegalArgumentException {
        if (!querystring.matches("^type=[^=]+&res=[^=]+")) throw new IllegalArgumentException("Illegal argument(s) in query");
        Map<String, String> queries = Arrays.stream(querystring.split("&"))
            .collect(Collectors.toMap(k -> k.split("=")[0], v -> v.split("=")[1]));
        return queries;
    }
}