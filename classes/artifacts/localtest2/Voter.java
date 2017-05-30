package web;

import alternativevoting.Candidate;
import alternativevoting.heroku;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Voter extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String Uname = request.getParameter("userName");

        String electionName = request.getParameter("electionName");
        System.out.print(electionName);
        int num = Integer.parseInt(request.getParameter("number"));
        heroku a = new heroku();
        ArrayList<String> cands = null;
        try {
            cands = a.retrieve(electionName);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=num;i++)
        {
            if(request.getParameter("vote"+i) != null) {
                list.add(Integer.parseInt(request.getParameter("vote" + i)));
            }
            else
            {
                list.add(Integer.MAX_VALUE);
            }
        }
        try {

            a.push(electionName, Uname, list);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.println("<center><h1 style=\"font-family: 'Segoe UI Light'; font-size: 72px; padding-top: 15vh;\">Thank you for participating in <span style=\"color: #008CBA;\">" + electionName + "</span>.</h1>" +
                "<br><a href=\"welcome.jsp\"><button type=\"button\" class=\"button button1\">Return to Home</button></a><center><style>\n" +
                "        .rep{\n" +
                "            font-family: \"Segoe UI Light\";\n" +
                "        }\n" +
                "        .button {\n" +
                "            background-color: #008CBA; /* Green */\n" +
                "            border: none;\n" +
                "            color: white;\n" +
                "            padding: 16px 32px;\n" +
                "            text-align: center;\n" +
                "            text-decoration: none;\n" +
                "            display: inline-block;\n" +
                "            font-size: 16px;\n" +
                "            margin: 4px 2px;\n" +
                "            -webkit-transition-duration: 0.4s; /* Safari */\n" +
                "            transition-duration: 0.4s;\n" +
                "            cursor: pointer;\n" +
                "            font-family: 'Segoe UI Light'\n" +
                "        }\n" +
                "\n" +
                "        .button1 {\n" +
                "            background-color: white;\n" +
                "            color: #008CBA;\n" +
                "            border: 2px solid #008CBA;\n" +
                "        }\n" +
                "\n" +
                "        .button1:hover {\n" +
                "            background-color: #008CBA;\n" +
                "            color: white;\n" +
                "        }\n" +
                "    </style>");
        out.flush();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}