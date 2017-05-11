package alternativevoting;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by aweso on 4/28/2017.
 */
public class backend {
    public static void main(String[] args){
        String hostName = "warowac";
        String dbName = "testDB";
        String user = "warowac";
        String password = "XoFruitL00ps";
        String url = String.format("jdbc:sqlserver://%s.database.windows.net:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url);
            Statement mystat = connection.createStatement();
            String lit = connection.getSchema();
            System.out.println("Success " + lit);

            String fats = "insert into warowac1 (name, 1, 2, 3, 4) values ('vote', 1, 3, 2, 4)";
            mystat.executeUpdate(fats);
            System.out.println("added the next value");

            ResultSet myRs = mystat.executeQuery("select * from Votes");

            while(myRs.next()){
                System.out.println(myRs.getString("name"));
            }

        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }


//    public void vote(String name, ArrayList<>)
}
