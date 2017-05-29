package alternativevoting;
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
        int num = Integer.parseInt(request.getParameter("number"));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=num;i++)
        {
            if(!request.getParameter("vote"+i).equals("")) {
                list.add(Integer.parseInt(request.getParameter("vote" + i)));
            }
            else
            {
                list.add(Integer.MAX_VALUE);
            }
        }

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

            PreparedStatement ps=con.prepareStatement(
                    "insert into registeruser values(?,?)");

            ps.setString(1,name);


            int i=ps.executeUpdate();
            if(i>0)
                out.print("You are successfully registered...");


        }catch (Exception e2) {System.out.println(e2);}

        out.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}  