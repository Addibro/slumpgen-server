package com.alming.slumpgen.storage;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

import com.web.http.Query;


public class Resources {
    public static Resource getResource(Map<String, Query> queries) {
        String type = queries.get("type").getValue();
        String res = queries.get("res").getValue();
        switch (type) {
            case "json":
                return new JsonResource(res);
            case "image":
                return new ImageResource(res);
            default:
                return null;
        }
    }
}