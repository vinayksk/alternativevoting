package alternativevoting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


/**
 * The delete class deletes tables from the backend. Created by aweso on
 * 5/11/2017.
 * 
 * @author vinay
 * @version May 11, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 *
 * @author Sources: None
 *
 */

public class delete
{
    /**
     * Main method.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String args[] )
    {
        String hostName = "warowac";
        String dbName = "testDB";
        String user = "warowac";
        String password = "XoFruitL00ps";
        String url = String.format(
            "jdbc:sqlserver://%s.database.windows.net:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
            hostName,
            dbName,
            user,
            password );
        Connection connection = null;

        Scanner s = new Scanner( System.in );
        System.out
            .println( "Enter the name of the table you would like to delete:" );
        String nxt = s.nextLine();

        try
        {
            connection = DriverManager.getConnection( url );
            Statement mystat = connection.createStatement();

            String del = "DROP TABLE " + nxt;
            mystat.executeUpdate( del );
            System.out.println( "deleted " + nxt + " from testDB" );
        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
        }
    }
}
