package com.alming.slumpgen.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.*;
import javax.servlet.http.*;

public class ImageResource implements Resource<Path> {
    
    public static final String PARCHMENT = "www/WEB-INF/res/media/parchment.png";
    public static final String PARCHMENT_BLOOD = "www/WEB-INF/res/media/parchment_blood.png";
    public static final String PARCHMENT_BURN = "www/WEB-INF/res/media/parchment_burn.png";
    public static final String PARCHMENT_BURNBLOOD = "www/WEB-INF/res/media/parchment_burnblood.png";
    public static final String TABLE = "www/WEB-INF/res/media/table.png";

    private String res;

    public ImageResource(String res) {
        this.res = res;
    }

    @Override
    public void setResponse(HttpServletResponse response, ServletContext context) throws IllegalArgumentException, FileNotFoundException, IOException{
        Path resource = getResource();
        String type = context.getMimeType(resource.toString());
        System.out.println("Mime type" + type);
        response.setHeader("Content-Type", context.getMimeType(resource.toFile().getName()));
        response.setHeader("Content-Length", String.valueOf(resource.toFile().length()));
        Files.copy(resource, response.getOutputStream());
    }

    @Override
    public Path getResource() throws IllegalArgumentException, FileNotFoundException, IOException {
        System.out.println(this.res);
        switch (this.res) {
            case "parchment":
                return Paths.get(PARCHMENT);
            case "parchment_blood":
                return Paths.get(PARCHMENT_BLOOD);
            case "parchment_burn":
                return Paths.get(PARCHMENT_BURN);
            case "parchment_burnblood":
                return Paths.get(PARCHMENT_BURNBLOOD);
            case "table":
                return Paths.get(TABLE);
            default:
                throw new IllegalArgumentException("ImageResource: No such resource");
        }
    }
}