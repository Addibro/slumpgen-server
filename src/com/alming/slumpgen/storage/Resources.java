package com.alming.slumpgen.storage;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class Resources {
    public static Resource getResource(Map<String, String> queries) throws IllegalArgumentException {
        String type = queries.get("type");
        String res = queries.get("res");
        switch (type) {
            case "json":
                return new JsonResource(res);
            case "image":
                return new ImageResource(res);
            default:
                throw new IllegalArgumentException("No such type");
        }
    }
}