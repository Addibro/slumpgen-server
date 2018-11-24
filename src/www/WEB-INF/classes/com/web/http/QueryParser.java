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

    public static Query parse(String querystring) {
        if (querystring == null || querystring.isEmpty()) return null;
        return new Query(querystring.split("=")[0], querystring.split("=")[1]);
    }
}