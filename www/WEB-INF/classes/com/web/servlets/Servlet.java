package com.web.servlets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.*;
import javax.servlet.http.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {    

        request.setCharacterEncoding(UTF_8.name());
        response.setContentType("application/json;charset=" + UTF_8.name());
        
        // response.setContentType("text/html;charset=" + UTF_8.name());

        // setup a output to write the response body
        PrintWriter out = response.getWriter();

        System.out.println(new java.util.Date() + " hello from servlet"); 

        

       
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        }
}