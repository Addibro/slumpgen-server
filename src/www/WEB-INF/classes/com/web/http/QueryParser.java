package com.web.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.web.http.Query;

/**
 *  //TODO
 */
public class QueryParser {
    private QueryParser() {}

    public static List<Query> parse(String querystring) {
        return (querystring.isEmpty() || querystring == null) 
        ? Collections.emptyList() 
        : Arrays.stream(querystring.split("&"))
            .map(q -> new Query(q.split("=")[0], q.split("=")[1]))
            .collect(Collectors.toList());
    }
}