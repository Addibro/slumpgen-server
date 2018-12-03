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


import com.web.http.Query;

/**
 *  //TODO
 */
public class QueryParser {

    private QueryParser() {}

    public static Query parse(String querystring) throws IllegalArgumentException, NoSuchElementException {
        if (!querystring.matches("^res=[^=]+")) throw new IllegalArgumentException("Illegal argument(s) in query");
        Optional<Query> queries = Arrays.stream(querystring.split("&"))
            .map(s -> new Query(s.split("=")[0], s.split("=")[1]))
            .filter(valueNotNullOrEmpty())
            .findFirst();
        return queries.get();
    }

    private static Predicate<Query> valueNotNullOrEmpty() {
        return query -> query.getValue() != null && !query.getValue().isEmpty();
    }
}