package alternativevoting;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * Created by aweso on 5/22/2017.
 */
public class heroku {
    public heroku(){

    }
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        retrieve("future");
//        ArrayList<String> cand = new ArrayList<>();
//        cand.add("me");
//        cand.add("you");
//        createTable("aids", cand);
//        System.out.println("-------- PostgreSQL "
//                + "JDBC Connection Testing ------------");
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Where is your PostgreSQL JDBC Driver? "
//                    + "Include in your library path!");
//            e.printStackTrace();
//            return;
//        }
//        System.out.println("PostgreSQL JDBC Driver Registered!");
//        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            // ========>     from heroku website
//            String url = String.format("jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require");
//            Properties props = new Properties();
//            props.setProperty("user", "ugtzulvykibvoo");
//            props.setProperty("password", "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb");
//            connection = DriverManager.getConnection(url, props);
//            String lit = connection.getSchema();
//            System.out.println("Success " + lit);
//
//            Statement stmt = connection.createStatement();
////            String sql = "CREATE TABLE COMPANY " +
////                    "(ID INT PRIMARY KEY     NOT NULL," +
////                    " NAME           TEXT    NOT NULL, " +
////                    " AGE            INT     NOT NULL, " +
////                    " ADDRESS        CHAR(50), " +
////                    " SALARY         REAL)";
////            stmt.executeUpdate(sql);
//            String fats = "insert into company (ID, name, age, address, salary) values (2, 'Jeff', 3, 22, 4)";
//            stmt.executeUpdate(fats);
//
//            ResultSet myRs = stmt.executeQuery("select * from company");
//
//            while(myRs.next()){
//                System.out.println(myRs.getString("name"));
//            }
//            stmt.close();
//            connection.close();
//        } catch (SQLException e) {
//
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return;
//        }
    }

    public void createTable(String electionName, ArrayList<String> candidates) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            try {
                // ========>     from heroku website
                String url = String.format("jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require");
                Properties props = new Properties();
                props.setProperty("user", "ugtzulvykibvoo");
                props.setProperty("password", "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb");
                connection = DriverManager.getConnection(url, props);
                String lit = connection.getSchema();
                System.out.println("Success " + lit);

                Statement stmt = connection.createStatement();
                String sql = "CREATE TABLE " + electionName + " (name char(50) PRIMARY KEY NOT NULL";
                for (int i = 0; i < candidates.size(); i++) {
                    sql = sql + ", " + candidates.get(i) + " INTEGER NOT NULL";
                }
                sql = sql + ")";
                System.out.println(sql);

                stmt.executeUpdate(sql);
                System.out.print("Database created");


                stmt.close();
                connection.close();
            } catch (SQLException e) {

                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();

            }

    }

    public static ArrayList<String> retrieve(String table) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        try {
            // ========>     from heroku website
            String url = String.format("jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require");
            Properties props = new Properties();
            props.setProperty("user", "ugtzulvykibvoo");
            props.setProperty("password", "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb");
            connection = DriverManager.getConnection(url, props);
            String lit = connection.getSchema();
            System.out.println("Success " + lit);

            ArrayList<String> val = new ArrayList<String>();
            Statement stmt = connection.createStatement();
            ResultSet myRs = stmt.executeQuery("select * from " + table);
            ResultSetMetaData md = myRs.getMetaData();
            int col = md.getColumnCount();

            for(int i = 2; i <= col; i++){
                val.add(md.getColumnName(i));
            }

            System.out.print("Values Retrieved");
            stmt.close();
            connection.close();
            return val;
        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }


    }

    public static void add(Map<String, Integer> mp){

    }
}
