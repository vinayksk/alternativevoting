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
        while ( !str.equals( "!" ) )
        {
            names.add( new Position( str ) );
            System.out.println( "Enter the name of Position " + ++count
                + " or \"!\" if there are no more positions:" );
            str = in.nextLine();
        }
        for ( Position pos : names )
        {
            HashMap<Candidate, Integer> votes = new HashMap<Candidate, Integer>(); // THIS
                                                                                   // IS
                                                                                   // BAD
                                                                                   // BECAUSE
                                                                                   // WE
                                                                                   // WANT
                                                                                   // RANKINGS
                                                                                   // NOT
                                                                                   // JUST
                                                                                   // INDIVUDUAL
                                                                                   // VOTES
            System.out.println( "Time for the election for the " + pos.getName()
                + " position!" );
            System.out.println( "Enter the name of Candidate 1:" );
            String s = in.nextLine();
            while ( !s.equals( "!" ) )
            {
                votes.put( new Candidate( s ), 0 );
                System.out.println(
                    "Enter the name of Candidate " + ( votes.size() + 1 )
                        + " for the position of " + pos.getName()
                        + " or \"!\" to move to the next position or step" );
                s = in.nextLine();
            }
            System.out.println( "Time to input votes!" );
            System.out
                .println( "Please enter ranking of candidate in order of " );
        }
        System.out.println( "Goodbye!" );
        in.close();
    }
}
