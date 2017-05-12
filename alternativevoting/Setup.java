package alternativevoting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.io.*;


public class Setup
{
    public static ElectionScreen e;


    public static void main( String[] a )
    {
        ArrayList<Candidate> names;
        String electionName;
        Scanner in = new Scanner( System.in );
        System.out.println( "What is the name of the election?" );
        electionName = in.nextLine();
        int count = 1;
        names = new ArrayList<Candidate>();
        System.out.println( "Enter the name of Candidate " + count + ":" );
        String str = in.nextLine();
        while ( !str.equals( "!" ) )
        {
            names.add( new Candidate( str ) );
            System.out.println( "Enter the name of Candidate " + ++count
                + " or \"!\" if there are no more candidates:" );
            str = in.nextLine();
        }
        e = new ElectionScreen( names, electionName );
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

        try
        {
            connection = DriverManager.getConnection( url );
            Statement mystat = connection.createStatement();

            String sql = "CREATE TABLE " + electionName
                + " (name VARCHAR(255) not NULL";

            for ( int i = 0; i < names.size(); i++ )
            {
                sql = sql + ", " + names.get( i ) + " INTEGER";
            }

            sql = sql + ", PRIMARY KEY ( name ))";
            System.out.println( sql );

            mystat.executeUpdate( sql );

            // String test = "DROP TABLE Election1 ";
            // mystat.executeUpdate(test);

        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
        }

        System.out.println( "Press any key to finish entering votes" );
        String filler = in.nextLine();
        ResultScreen r = new ResultScreen(electionName);
        in.close();
    }
}
