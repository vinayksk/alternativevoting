import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Voter extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name =request.getParameter("userName");
        String age=request.getParameter("age");

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

            PreparedStatement ps=con.prepareStatement(
                    "insert into registeruser values(?,?)");

            ps.setString(1,name);
            ps.setString(2, age);

            int i=ps.executeUpdate();
            if(i>0)
                out.print("You are successfully registered...");


        }catch (Exception e2) {System.out.println(e2);}

        out.close();
    }

}  