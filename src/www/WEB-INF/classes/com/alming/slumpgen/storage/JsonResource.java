package com.alming.slumpgen.storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JsonResource implements Resource {

    private String res;

    public static final String NAMES = "www/WEB-INF/res/json/names.json";
    public static final String NICKNAMES = "www/WEB-INF/res/json/nicknames.json";
    public static final String CREEDS = "www/WEB-INF/res/json/creeds.json";

    public JsonResource(String res) {
        this.res = res;
    }

    @Override
    public void setResponse(HttpServletResponse response) 
        throws IllegalArgumentException, FileNotFoundException, IOException {
        // Set content type 
        response.setContentType("application/json;charset=" + UTF_8.name());
        PrintWriter out = response.getWriter();
        out.append(this.getResource());
    }

    private String getResource() throws IllegalArgumentException, FileNotFoundException {
        switch (this.res) {
            case "names":
                return read(JsonResource.NAMES);
            case "nicknames":
                return read(JsonResource.NICKNAMES);
            case "creeds":
                return read(JsonResource.CREEDS);        
            default:
                throw new IllegalArgumentException("No resource");
        }
    }

    private String read(String res) throws FileNotFoundException {
        return new BufferedReader(new FileReader(res))
            .lines()
            .collect(Collectors.joining())
            .toString();
    }
}