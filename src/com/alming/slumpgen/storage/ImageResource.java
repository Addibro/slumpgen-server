package com.alming.slumpgen.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.*;
import javax.servlet.http.*;

public class ImageResource implements Resource<Path> {
    
    private String res;
    private static final String PATH = "www/WEB-INF/res/media/";

    public ImageResource(String res) {
        this.res = res;
    }

    @Override
    public void setResponse(HttpServletResponse response, ServletContext context) throws IllegalArgumentException, FileNotFoundException, IOException{
        Path resource = getResource();
        String type = context.getMimeType(resource.toString());
        response.setHeader("Content-Type", context.getMimeType(resource.toFile().getName()));
        response.setHeader("Content-Length", String.valueOf(resource.toFile().length()));
        Files.copy(resource, response.getOutputStream());
    }

    @Override
    public Path getResource() throws IllegalArgumentException, FileNotFoundException, IOException {
        System.out.println(this.res);
        return Paths.get(PATH + this.res);
    }
}