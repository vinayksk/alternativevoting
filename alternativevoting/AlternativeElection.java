package alternativevoting;

import java.util.*;
import java.io.*;


public class AlternativeElection
{

    public static void main( String[] args )
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
        HashSet<Ballot> set = new HashSet<Ballot>();
        int count2 = 1;
        System.out.println( "Enter ballot " + count2 + ":" );
        str = in.nextLine();
        ArrayList<String> temp = new ArrayList<String>();
        while ( !str.equals( "!" ) )
        {
            str.split( "\\s+" );
            temp.add( str );
            Ballot b = new Ballot();
            set.add( b );
            for ( int i = 1; i <= count; i++ )
            {
                if ( str.contains( i + "" ) )
                {
                    b.add( names.get( str.indexOf( i + "" ) ) );
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
        int[][] ballots = new int[count2][count];
        for ( int i = 0; i < count2; i++ )
        {
            for ( int j = 0; j < count; j++ )
            {
                ballots[i][j] = temp.get( i ).charAt( j ) - '0';
            }
        }
        String[][] pref = new String[count + 1][count + 1];
        for ( int i = 1; i <= count; i++ )
        {
            pref[i][0] = pref[0][i] = names.get( i - 1 ).getName();
        }
        for ( int i = 0; i <= count; i++ )
        {
            pref[i][i] = "X";
        }
        int[][] prefint = new int[count + 1][count + 1];
        double[][] prefper = new double[count + 1][count + 1];
        for ( int i = 1; i < count; i++ )
        {
            for ( int j = i + 1; j <= count; j++ )
            {
                for ( int k = 0; k < count2; k++ )
                {
                    prefint[i][j] += ballots[k][i - 1] < ballots[k][j - 1] ? 1
                        : 0;
                    prefint[j][i] += ballots[k][i - 1] > ballots[k][j - 1] ? 1
                        : 0;
                    prefper[i][j] = (int)( 1000 * ( prefint[i][j]
                        / ( 0.0 + prefint[i][j] + prefint[j][i] ) ) ) / 10.0;
                    prefper[j][i] = (int)( 1000 * ( prefint[j][i]
                        / ( 0.0 + prefint[i][j] + prefint[j][i] ) ) ) / 10.0;
                }
            }
        }
        for ( int i = 1; i <= count; i++ )
        {
            for ( int j = 1; j <= count; j++ )
            {
                if ( i != j )
                {
                    pref[i][j] = prefint[i][j] + "";
                }
            }
        }
        for ( String[] i : pref )
        {
            for ( String j : i )
            {
                System.out.print( j + "\t" );
            }
            System.out.println();
        }
        System.out.println();
        for ( int i = 1; i <= count; i++ )
        {
            for ( int j = 1; j <= count; j++ )
            {
                if ( i != j )
                {
                    pref[i][j] = prefper[i][j] + "";
                }
            }
        }
        for ( String[] i : pref )
        {
            for ( String j : i )
            {
                System.out.print( j + "\t" );
            }
            System.out.println();
        }
        for ( Ballot b : set )
        {
            b.getList().get( 0 ).changeVotes( 1 );
        }
        Collections.sort( names );
        System.out.println(
            "First-past-the-post winner: " + names.get( names.size() - 1 ) );
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
            for ( Ballot b : set )
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
        System.out.println( "Alternative vote winner: "
            + names.get( names.size() - 1 ).getName() );
    }
}
