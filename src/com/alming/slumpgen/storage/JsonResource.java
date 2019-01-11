package com.alming.slumpgen.storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JsonResource implements Resource<String> {

    private String res;
    public static final String PATH = "www/WEB-INF/res/json/";

    public JsonResource(String res) {
        this.res = res;
    }

    @Override
    public void setResponse(HttpServletResponse response, ServletContext context) 
        throws IllegalArgumentException, FileNotFoundException, IOException {
        // Set content type 
        response.setContentType("application/json;charset=" + UTF_8.name());
        PrintWriter out = response.getWriter();
        out.append(this.getResource());
        out.close();
    }

    @Override
    public String getResource() throws IllegalArgumentException, FileNotFoundException, IOException {
        return read(PATH + this.res);
    }

    private String read(String res) throws NoSuchFileException, IOException {
        return new String(Files.readAllBytes(Paths.get(res)), UTF_8.name());
    }
}