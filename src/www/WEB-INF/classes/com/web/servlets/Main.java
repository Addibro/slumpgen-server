package com.web.servlets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.*;

import com.alming.slumpgen.storage.SQLGetCharacters;
import com.alming.slumpgen.characters.*;
import com.web.json.FBLCharacterFormatter;
import com.web.json.RPGCharacterFormatter;
import com.web.json.FBLCharacterJsonParser;
import com.web.http.QueryParser;
import com.web.http.Query;

import static java.nio.charset.StandardCharsets.UTF_8;

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

        // Set request encoding
        request.setCharacterEncoding(UTF_8.name());
        // Set content type 
        response.setContentType("application/json;charset=" + UTF_8.name());
        // Check querystring 
        List<Query> queries = QueryParser.parse(request.getQueryString());

        // setup a output to write the response body
        PrintWriter out = response.getWriter();        

        
        SQLGetCharacters sqlGetCharacters = new SQLGetCharacters();
        
        List<FBLCharacter> fblCharacters = new ArrayList<>();
        fblCharacters.addAll(Arrays.asList(new FBLCharacterBuilder().with(c -> {
            c.name = "andy"; 
            c.nickname = "andypandy"; 
            c.appearance = "very cool";
            c.kin = "human";
            c.profession = "pro";
            c.age = "100";
            c.attributes = new HashMap<String, String>();
        }).createFBLCharacter(), new FBLCharacterBuilder().with(c -> {
            c.name = "davy"; 
            c.nickname = "davy gravy"; 
            c.appearance = "average";
            c.kin = "human";
            c.profession = "pro";
            c.age = "100";
            c.attributes = new HashMap<String, String>();
        }).createFBLCharacter()));
        FBLCharacterFormatter formatter = new FBLCharacterFormatter(fblCharacters);

        String jsonOutput = formatter.format();

        System.out.println(new java.util.Date() + " hello from servlet"); 

        out.append(jsonOutput);
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        System.out.println("Method type: " + request.getMethod());

        // System.out.println(request.getIntHeader(""));
        // Get character posted
        String json = request.getReader()
            .lines()
            .collect(Collectors.toList())
            .toString();
        FBLCharacterJsonParser parser = new FBLCharacterJsonParser();
        try {
            System.out.println(parser.parse(json));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}