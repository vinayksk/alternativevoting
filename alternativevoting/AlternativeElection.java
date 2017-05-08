package alternativevoting;

import java.util.*;
import java.io.*;


public class AlternativeElection
{

    public static void main( String[] a )
    {
        Scanner in = new Scanner( System.in );
        int count = 1;
        ArrayList<Candidate> names = new ArrayList<Candidate>();
        System.out.println( "Enter the name of Candidate " + count + ":" );
        String str = in.nextLine();
        while ( !str.equals( "!" ) )
        {
            names.add( new Candidate( str ) );
            System.out.println( "Enter the name of Candidate " + ++count
                + " or \"!\" if there are no more candidates:" );
            str = in.nextLine();
        }
        count--;
        ArrayList<Ballot> list = new ArrayList<Ballot>();
        int count2 = 1;
        System.out.println( "Enter ballot " + count2 + ":" );
        str = in.nextLine();
        while ( !str.equals( "!" ) )
        {
            list.add( new Ballot() );
            for ( int i = 1; i <= count; i++ )
            {
                if ( str.contains( i + "" ) )
                {
                    list.get( count2 - 1 )
                        .add( names.get( str.indexOf( i + "" ) ) );
                }
                else
                {
                    break;
                }
            }
            System.out.println( "Enter ballot " + ++count2
                + " or \"!\" if there are no more ballots:" );
            str = in.nextLine();
        }
        count2--;
        for ( Ballot b : list )
        {
            b.getList().get( 0 ).changeVotes( 1 );
        }
        Collections.sort( names );
        while ( names.size() > 1
            && 2 * names.get( names.size() - 1 ).getVotes() <= count2 )
        {
            int min = names.get( 0 ).getVotes();
            int max = names.get( names.size() - 1 ).getVotes();
            if ( min == max )
            {
                System.out.println(
                    "There is a tie between the following candidates: "
                        + names );
                return;
            }
            ArrayList<Candidate> remove = new ArrayList<Candidate>();
            for ( int i = names.size() - 1; i >= 0; i-- )
            {
                if ( names.get( i ).getVotes() == min )
                {
                    remove.add( names.remove( i ) );
                }
            }
            for ( Ballot b : list )
            {
                for ( int i = b.getList().size() - 1; i >= 0; i-- )
                {
                    if ( remove.contains( b.getList().get( i ) ) )
                    {
                        b.getList().remove( i );
                        if ( i == 0 && !b.getList().isEmpty() )
                        {
                            b.getList().get( i ).changeVotes( 1 );
                        }
                    }
                }
            }
            Collections.sort( names );
        }
        System.out.println(
            "The winner is " + names.get( names.size() - 1 ).getName() + "!" );
    }
}
