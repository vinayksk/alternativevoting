package alternativevoting;

import java.util.*;
import java.io.*;


public class AlternativeElection
{

    public static void main( String[] a )
    {
        Scanner in = new Scanner( System.in );

        int count = 1;
        ArrayList<Position> names = new ArrayList<Position>();
        System.out.println( "Enter the name of Position " + count + ":" );
        String str = in.nextLine();
        names.add( new Position( str ) );
        while ( !str.equals( "!" ) )
        {

            System.out.println( "Enter the name of Position " + ++count
                + " or \"!\" if there are no more positions:" );
            str = in.nextLine();

        }
        for ( Position pos : names )
        {
            System.out.println(
                "Enter the name of Candidate " + ( pos.names.size() + 1 )
                    + " for the position of " + pos.getName()
                    + " or \"!\" to move to the next position or step" );
        }
        System.out.println( "Goodbye!" );
        in.close();
    }
}
