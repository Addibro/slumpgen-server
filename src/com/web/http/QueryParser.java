package com.web.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QueryParser {

    private static Function<String, String> key = keyString -> keyString.split("=")[0];
    private static Function<String, String> value = valueString -> valueString.split("=")[1];

    private QueryParser() {
    }

    public static Map<String, String> parse(String querystring) throws IllegalArgumentException {
        if (invalidQuery(querystring))
            throw new IllegalArgumentException("Illegal argument(s) in query");
        Map<String, String> queries = Arrays.stream(querystring.split("&"))
                .collect(Collectors.toMap(QueryParser.key, QueryParser.value));
        return queries;
    }

    private static boolean invalidQuery(String querystring) {
        return !querystring.matches("^type=[^=]+&res=[^=]+");
    }
}