package com.web.servlets;

import java.io.BufferedReader;
import java.io.File;
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
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.*;

import com.alming.slumpgen.storage.Resources;
import com.alming.slumpgen.storage.SQLGetCharacters;
import com.alming.slumpgen.characters.*;
import com.web.json.FBLCharacterFormatter;
import com.web.json.FBLCharacterJsonParser;
import com.web.http.QueryParser;
import com.web.http.Query;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main extends HttpServlet {

    private static final String NAMES = "/";

    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {   

        System.out.println("RequestURL(): " + request.getRequestURI());
        System.out.println("Method type: " + request.getMethod());

        // Set request encoding
        request.setCharacterEncoding(UTF_8.name());
        // Set content type 
        response.setContentType("application/json;charset=" + UTF_8.name());

        // setup a output to write the response body
        PrintWriter out = response.getWriter();        
        
        // SQLGetCharacters sqlGetCharacters = new SQLGetCharacters();
        // List<FBLCharacter> fblCharacters = sqlGetCharacters.getAllCharacters();
        // FBLCharacterFormatter formatter = new FBLCharacterFormatter(fblCharacters);
        // String jsonOutput = formatter.format();

        System.out.println(new java.util.Date() + ", doGet"); 

        // Check querystring 
        Query query = QueryParser.parse(request.getQueryString());
        System.out.println(query);
        if (query == null) response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        else {
            switch (query.getValue()) {
                case "names":
                    String names = Resources.getResource(Resources.NAMES);
                    out.append(names);
                    break;
                case "nicknames":
                    String nicknames = Resources.getResource(Resources.NICKNAMES);
                    out.append(nicknames);
                    break;
                case "creeds":
                    String creeds = Resources.getResource(Resources.CREEDS);        
                    out.append(creeds);
                    break;
                default:
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

            out.close();
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