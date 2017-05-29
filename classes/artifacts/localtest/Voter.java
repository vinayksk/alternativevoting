package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Andrew on 5/26/2017.
 */
@WebServlet(name = "Voter")
public class Voter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name =request.getParameter("userName");

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            // ========>     from heroku website
            String url = String.format("jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require");
            Properties props = new Properties();
            props.setProperty("user", "ugtzulvykibvoo");
            props.setProperty("password", "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb");
            connection = DriverManager.getConnection(url, props);
            String lit = connection.getSchema();
            System.out.println("Success " + lit);

            Statement stmt = connection.createStatement();
//            String sql = "CREATE TABLE COMPANY " +
//                    "(ID INT PRIMARY KEY     NOT NULL," +
//                    " NAME           TEXT    NOT NULL, " +
//                    " AGE            INT     NOT NULL, " +
//                    " ADDRESS        CHAR(50), " +
//                    " SALARY          REAL)";
//            stmt.executeUpdate(sql);
            String url2 = "insert into aids (name, me, you) values (" + name + ", 'b', 'c')";
            stmt.executeUpdate(url2);
            stmt.close();
            connection.close();
        } catch (Exception e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
