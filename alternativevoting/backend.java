package alternativevoting;
import java.sql.*;
import java.util.ArrayList;

/**
 * Provides backend support for tables.
 *
 * Created by aweso on 4/28/2017.
 * @author vinay
 * @version May 23, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 */
public class backend {
    /**
     *
     * Main method for testing.
     * @param args is not used
     */
    public static void main(String[] args){
        String hostName = "warowac";
        String dbName = "testDB";
        String user = "warowac";
        String password = "XoFruitL00ps";
        String url = String.format("jdbc:sqlserver://%s.database.windows.net:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        String url2 = String.format("jdbc:postgresql://ugtzulvykibvoo:288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb@ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu");
        Connection connection = null;

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url2);
            Statement mystat = connection.createStatement();
            String lit = connection.getSchema();
            System.out.println("Success " + lit);
//
////            String fats = "insert into warowac1 (name, 1, 2, 3, 4) values ('vote', 1, 3, 2, 4)";
////            mystat.executeUpdate(fats);
////            System.out.println("added the next value");
//
//            ResultSet myRs = mystat.executeQuery("select * from crigne8");
//
//            while(myRs.next()){
//                System.out.println(myRs.getString("vinay"));
//            }

        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }


//    public void vote(String name, ArrayList<>)
}
