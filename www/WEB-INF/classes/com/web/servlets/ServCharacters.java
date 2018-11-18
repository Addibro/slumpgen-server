package com.web.servlets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.*;
import javax.servlet.http.*;

import com.alming.slumpgen.storage.SQLGetCharacters;
import com.alming.slumpgen.characters.*;
import com.web.json.FBLCharacterFormatter;
import com.web.json.RPGCharacterFormatter;
import com.web.http.QueryParser;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ServCharacters extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {    

        request.setCharacterEncoding(UTF_8.name());
        response.setContentType("application/json;charset=" + UTF_8.name());

        // setup a output to write the response body
        PrintWriter out = response.getWriter();

        SQLGetCharacters sqlGetCharacters = new SQLGetCharacters();
        List<RPGCharacter> rpgCharacters = sqlGetCharacters.getAllCharacters();
        List<FBLCharacter> fblCharacters = new ArrayList<>();
        fblCharacters.add(new FBLCharacterBuilder().with(c -> {
            c.name = "andy"; 
            c.nickname = "andypandy"; 
            c.appearance = "very cool";
            c.kin = "human";
            c.profession = "pro";
            c.age = "100";
            c.attributes = new HashMap<String, String>();
        }).createFBLCharacter());
        FBLCharacterFormatter formatter = new FBLCharacterFormatter(fblCharacters);
        String jsonOutput = formatter.format();


        // SQLGetCharacters sql = new SQLGetCharacters();
        // List<RPGCharacter> rpgCharacters = sql.getAllCharacters();
        System.out.println(new java.util.Date() + " hello from servlet"); 

        out.append(jsonOutput);
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        }
}