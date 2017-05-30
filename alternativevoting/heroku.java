package alternativevoting;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;


/**
 *
 * Heroku queries from a database and returns relevant information.
 *
 * @author vinay
 * @version May 24, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 *
 * @author Sources: None
 */
public class heroku
{
    /**
     * Creates a new heroku object.
     */
    public heroku()
    {

    }


    /**
     * Main test method.
     * 
     * @param args
     *            not used
     * @throws InstantiationException instantiation error
     * @throws IllegalAccessException illegal access error
     * @throws ClassNotFoundException class not found error
     */
    public static void main( String[] args )
        throws InstantiationException,
        IllegalAccessException,
        ClassNotFoundException
    {
        System.out.print( retrieve( "future" ) );
        request( "future" );
        ArrayList<Integer> ranks = new ArrayList<>();
        ranks.add( 1 );
        ranks.add( 2 );
        ranks.add( 3 );
        // push("vinsta", "fat", ranks);
        System.out.println( clear( "designner" ) );
    }


    /**
     * Creates a new table for the heroku website.
     * 
     * @param electionName
     *            The name of the election
     * @param candidates
     *            The list of candidate names.
     * @throws InstantiationException instantiation error
     * @throws IllegalAccessException illegal access error
     * @throws ClassNotFoundException class not found error
     */
    public void createTable( String electionName, ArrayList<String> candidates )
        throws InstantiationException,
        IllegalAccessException,
        ClassNotFoundException
    {
        Class.forName( "org.postgresql.Driver" );
        Connection connection = null;
        try
        {
            // ========> from heroku website
            String url = String.format(
                "jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require" );
            Properties props = new Properties();
            props.setProperty( "user", "ugtzulvykibvoo" );
            props.setProperty( "password",
                "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb" );
            connection = DriverManager.getConnection( url, props );
            String lit = connection.getSchema();
            System.out.println( "Success " + lit );

            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE " + electionName
                + " (name char(50) PRIMARY KEY NOT NULL";
            for ( int i = 0; i < candidates.size(); i++ )
            {
                sql = sql + ", " + candidates.get( i ) + " INTEGER NOT NULL";
            }
            sql = sql + ")";
            System.out.println( sql );

            stmt.executeUpdate( sql );
            System.out.print( "Database created" );

            stmt.close();
            connection.close();
        }
        catch ( SQLException e )
        {

            System.out.println( "Connection Failed! Check output console" );
            e.printStackTrace();

        }

    }


    /**
     * Retrieves the candidate names from a table.
     * 
     * @param table
     *            the table name to retrieve from
     * @return candidate names in an arraylist of strings
     * @throws InstantiationException instantiation error
     * @throws IllegalAccessException illegal access error
     * @throws ClassNotFoundException class not found error
     */
    public static ArrayList<String> retrieve( String table )
        throws InstantiationException,
        IllegalAccessException,
        ClassNotFoundException
    {
        Class.forName( "org.postgresql.Driver" );
        Connection connection = null;
        try
        {
            // ========> from heroku website
            String url = String.format(
                "jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require" );
            Properties props = new Properties();
            props.setProperty( "user", "ugtzulvykibvoo" );
            props.setProperty( "password",
                "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb" );
            connection = DriverManager.getConnection( url, props );
            String lit = connection.getSchema();
            System.out.println( "Success " + lit );

            ArrayList<String> val = new ArrayList<String>();
            Statement stmt = connection.createStatement();
            ResultSet myRs = stmt.executeQuery( "select * from " + table );
            ResultSetMetaData md = myRs.getMetaData();
            int col = md.getColumnCount();

            for ( int i = 2; i <= col; i++ )
            {
                val.add( md.getColumnName( i ) );
            }

            System.out.println( "Values Retrieved" );
            stmt.close();
            connection.close();
            return val;
        }
        catch ( SQLException e )
        {

            System.out.println( "Connection Failed! Check output console" );
            e.printStackTrace();
            return null;

        }

    }


    /**
     * Returns the ballots from a table in array format. Each column is a
     * ballot.
     * 
     * @param table
     *            the table name to request from.
     * @return ballots in array format, with columns as ballots.
     * @throws InstantiationException instantiation error
     * @throws IllegalAccessException illegal access error
     * @throws ClassNotFoundException class not found error
     */
    public static int[][] request( String table )
        throws InstantiationException,
        IllegalAccessException,
        ClassNotFoundException
    {
        Class.forName( "org.postgresql.Driver" );
        Connection connection = null;
        try
        {
            // ========> from heroku website
            String url = String.format(
                "jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require" );
            Properties props = new Properties();
            props.setProperty( "user", "ugtzulvykibvoo" );
            props.setProperty( "password",
                "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb" );
            connection = DriverManager.getConnection( url, props );
            String lit = connection.getSchema();
            System.out.println( "Success " + lit );

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery( "SELECT COUNT(*) FROM " + table );
            rs.next();
            int rowCount = rs.getInt( 1 );
            System.out.println( rowCount );
            ArrayList<String> candidates = retrieve( table );
            int len = candidates.size();
            int[][] ballots = new int[len][rowCount];
            rs.close();

            for ( int i = 0; i < len; i++ )
            {
                ResultSet myRs = st.executeQuery( "SELECT * FROM " + table );
                int j = 0;
                while ( myRs.next() )
                {
                    ballots[i][j] = ( myRs.getInt( candidates.get( i ) ) );
                    j++;
                }
                myRs.close();
            }
            st.close();
            connection.close();

            for ( int i = 0; i < ballots.length; i++ )
            {
                for ( int j = 0; j < ballots[0].length; j++ )
                {
                    System.out.print( ballots[i][j] + " " );
                }
                System.out.println( "" );
            }
            return ballots;

        }
        catch ( SQLException e )
        {
            System.out.println( "Connection Failed! Check output console" );
            e.printStackTrace();
            return null;

        }
    }


    /**
     * Pushes a ballot to a table.
     * 
     * @param elecname
     *            The table name
     * @param name
     *            Name of voter
     * @param ranks
     *            The ballot ranks
     * @throws InstantiationException instantiation error
     * @throws IllegalAccessException illegal access error
     * @throws ClassNotFoundException class not found error
     */
    public static void push(
        String elecname,
        String name,
        ArrayList<Integer> ranks )
        throws InstantiationException,
        IllegalAccessException,
        ClassNotFoundException
    {
        Class.forName( "org.postgresql.Driver" );
        Connection connection = null;
        try
        {
            // ========> from heroku website
            String url = String.format(
                "jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require" );
            Properties props = new Properties();
            props.setProperty( "user", "ugtzulvykibvoo" );
            props.setProperty( "password",
                "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb" );
            connection = DriverManager.getConnection( url, props );
            String lit = connection.getSchema();
            System.out.println( "Success " + lit );
            Statement stmt = connection.createStatement();

            ArrayList<String> candidates = retrieve( elecname );

            String sql = "insert into " + elecname + " (name";
            for ( int i = 0; i < candidates.size(); i++ )
            {
                sql = sql + ", " + candidates.get( i );
            }
            sql = sql + ") VALUES (" + "\'" + name + "\'";
            for ( int i = 0; i < ranks.size(); i++ )
            {
                sql = sql + ", " + ranks.get( i );
            }
            sql = sql + ")";
            System.out.println( sql );
            System.out.println( "Values added to the database" );
            stmt.executeUpdate( sql );
            stmt.close();
            connection.close();
        }
        catch ( Exception e )
        {

            System.out.println( "Connection Failed! Check output console" );
            e.printStackTrace();
        }

    }


    /**
     * Returns whether a table is clear
     * 
     * @param elecname
     *            the name of election
     * @return true if and only if there is no table with this name
     * @throws InstantiationException instantiation error
     * @throws IllegalAccessException illegal access error
     * @throws ClassNotFoundException class not found error
     */
    public static boolean clear( String elecname )
        throws InstantiationException,
        IllegalAccessException,
        ClassNotFoundException
    {
        Class.forName( "org.postgresql.Driver" );
        Connection connection = null;
        try
        {
            // ========> from heroku website
            String url = String.format(
                "jdbc:postgresql://ec2-54-163-254-76.compute-1.amazonaws.com:5432/dahhebb44gsieu?sslmode=require" );
            Properties props = new Properties();
            props.setProperty( "user", "ugtzulvykibvoo" );
            props.setProperty( "password",
                "288db9b457f62a3f7333f910087e6d79f38bd205a3e47841596d2658a93cfdbb" );
            connection = DriverManager.getConnection( url, props );
            String lit = connection.getSchema();
            System.out.println( "Success " + lit );
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables( null, null, "%", null );
            ArrayList<String> lis = new ArrayList<>();
            while ( rs.next() )
            {
                lis.add( rs.getString( "TABLE_NAME" ) );
            }
            boolean bool = !lis.contains( elecname );
            connection.close();
            return bool;
        }
        catch ( Exception e )
        {

            System.out.println( "Connection Failed! Check output console" );
            e.printStackTrace();
            return false;
        }
    }

}
