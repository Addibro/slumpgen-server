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

import org.json.*;

import com.alming.slumpgen.storage.Resources;
import com.alming.slumpgen.storage.Resource;
import com.alming.slumpgen.storage.SQLGetCharacters;
import com.alming.slumpgen.characters.*;
import com.web.json.FBLCharacterFormatter;
import com.web.json.FBLCharacterJsonParser;
import com.web.http.QueryParser;
import com.web.http.Query;

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
        String querystring = request.getQueryString();
        // Check and parse querystring 
        try {
            Map<String, Query> queries = QueryParser.parse(querystring);
            Resource resource = Resources.getResource(queries);
            resource.setResponse(response);
        } catch (NoSuchElementException | IllegalArgumentException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
        } catch (FileNotFoundException ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } 
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        System.out.println("RequestURL(): " + request.getRequestURI());
        System.out.println("Method type: " + request.getMethod());

        // System.out.println(request.getIntHeader(""));
        // Get character posted
        String json = request.getReader()
            .lines()
            .collect(Collectors.toList())
            .toString();
        FBLCharacterJsonParser parser = new FBLCharacterJsonParser();
        
        System.out.println("json: " + json);

        try {
            List<FBLCharacter> character = parser.parse(json);
            System.out.println(character);
            

        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println(ex);
        }
    }
}