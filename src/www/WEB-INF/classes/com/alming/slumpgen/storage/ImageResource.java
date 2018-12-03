package com.alming.slumpgen.storage;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class ImageResource implements Resource {

    private String res;

    public ImageResource(String res) {
        this.res = res;
    }

    @Override
    public void setResponse(HttpServletResponse response) throws IllegalArgumentException, FileNotFoundException, IOException{
        
    }
}