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
 * Posts new election.
 *
 * @author vinay
 * @version May 29, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 *
 * @author Sources: None
 */
public class ServletTest extends HttpServlet {
    /**
     * Creates a new election.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String elecname = request.getParameter("nameOfElec");
        out.println("<center><h1 style=\"font-family: 'Segoe UI Light'; font-size: 72px; padding-top: 15vh;\">Thank you for creating <span style=\"color: #008CBA;\">" + elecname + "</span>.</h1>" +
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

    /**
     * Creates a new election.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>its lit</h1>");
        out.flush();
    }
}
