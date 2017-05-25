package alternativevoting;

import java.sql.*;
import java.util.Properties;

/**
 * Created by aweso on 5/22/2017.
 */
public class heroku {
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver Registered!");
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
//                    " SALARY         REAL)";
//            stmt.executeUpdate(sql);

            ResultSet myRs = stmt.executeQuery("select * from company");

            while(myRs.next()){
                System.out.println(myRs.getString("name"));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

}
