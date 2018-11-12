package com.web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set character encoding to UTF-8
        request.setCharacterEncoding(UTF_8.name());

        // "we are sending you html, using UTF-8"
        // this makes sure that the browser know how to render the page
        response.setContentType("text/html;charset=" + UTF_8.name());

        // setup a output to write the response body
        PrintWriter out = new PrintWriter(
                new OutputStreamWriter(response.getOutputStream(), UTF_8.name()), true
        );
        System.out.println(new java.util.Date() + " hello from servlet");
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head><title>Servlet title</title></head>");
        out.println("<body>");
        out.println("<h1>Hello from the servlet!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}