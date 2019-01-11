package com.web.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

import com.alming.slumpgen.storage.Resources;
import com.alming.slumpgen.storage.Resource;
import com.web.http.QueryParser;

public class Main extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {   

        System.out.println("RequestURL(): " + request.getRequestURI());
        System.out.println("Method type: " + request.getMethod());
        ServletContext context = getServletContext();
        String querystring = request.getQueryString();
        // Check and parse querystring 
        try {
            Map<String, String> queries = QueryParser.parse(querystring);
            Resource resource = Resources.getResource(queries);
            resource.setResponse(response, context);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
        } catch (NoSuchFileException ex) {
            System.out.println(ex);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Exception ex) {
            System.out.println(ex);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}