package web;

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

        String name = request.getParameter("userName");
        String electionName = request.getParameter("electionName");
        int num = Integer.parseInt(request.getParameter("number"));
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

        heroku a = new heroku();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}