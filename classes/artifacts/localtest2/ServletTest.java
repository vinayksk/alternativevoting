package web;

import alternativevoting.heroku;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by aweso on 5/26/2017.
 */
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String elecname = request.getParameter("nameOfElec");
        out.println("<center><h1 style=\"font-family: 'Segoe UI Light'; font-size: 72px; padding-top: 15vh;\">Thank you for creating " + elecname + "</h1>" +
                "<br><button type=\"button\" onclick=\"welcome.jsp\">Home</button><center>");
        ArrayList<String> lis = new ArrayList<>();
        heroku hero = new heroku();
        for (int i = 1; i <= Integer.parseInt(request.getParameter("numCand")); i++) {
            String id = "r" + i;
            lis.add(request.getParameter(id));
        }
        try {
            hero.createTable(elecname, lis);
        } catch ( ClassNotFoundException e ) {
            System.out.println("Connection Failed! Class not found");
            e.printStackTrace();
        } catch ( InstantiationException e ) {
            System.out.println("Connection Failed! instiation prob");
            e.printStackTrace();
        } catch ( IllegalAccessException e ) {
            System.out.println("Connection Failed! illegal access");
            e.printStackTrace();
        }

        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>its lit</h1>");
        out.flush();
    }
}
