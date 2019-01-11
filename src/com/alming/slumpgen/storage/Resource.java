package com.alming.slumpgen.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

public interface Resource<T> {
    void setResponse(HttpServletResponse response, ServletContext context) throws IllegalArgumentException, NoSuchFileException, IOException;
    T getResource() throws IllegalArgumentException, NoSuchFileException, IOException;
}