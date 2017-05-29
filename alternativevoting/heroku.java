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
        System.out.print(retrieve("future"));
        request("future");

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

            System.out.println("Values Retrieved");
            stmt.close();
            connection.close();
            return val;
        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }


    }

    public static int[][] request(String table)throws InstantiationException,
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

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM " + table);
            rs.next();
            int rowCount = rs.getInt(1);
            System.out.println(rowCount);
            ArrayList<String> candidates = retrieve(table);
            int len = candidates.size();
            int[][] ballots = new int[len][rowCount];
            rs.close();

            for(int i = 0; i < len; i++){
                ResultSet myRs = st.executeQuery("SELECT * FROM " + table);
                int j = 0;
                while(myRs.next()){
                    ballots[i][j] = (myRs.getInt(candidates.get(i)));
                    j++;
                }
                myRs.close();
            }
            st.close();
            connection.close();

            for(int i=0;i<ballots.length;i++)
            {
                for(int j=0;j<ballots[0].length;j++)
                {
                    System.out.print(ballots[i][j] + " ");
                }
                System.out.println("");
            }
            return ballots;


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }
    }
}
