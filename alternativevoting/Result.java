package alternativevoting;

import java.util.*;


/**
 * Creates a ResultScreen object.
 *
 * @author Andrew Lin
 * @version May 29, 2017
 * @author Assignment: Final Project
 *
 * @author Sources: None
 *
 */
public class Result
{
    private ResultScreen r;


    /**
     * Creates a new ResultScreen based on election name.
     * 
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    public Result()
        throws IllegalAccessException,
        ClassNotFoundException,
        InstantiationException
    {
        Scanner in = new Scanner( System.in );
        System.out.println( "Which election do we want results for?" );
        String str = in.nextLine();
        heroku a = new heroku();
        ArrayList<String> candNames = a.retrieve( str );
        ArrayList<Candidate> candList = new ArrayList<Candidate>();
        for ( int i = 0; i < candNames.size(); i++ )
        {
            candList.add( new Candidate( candNames.get( i ) ) );
        }
        LinkedList<Queue<Candidate>> list = new LinkedList<Queue<Candidate>>();
        int[][] ballots = a.request( str );
        for ( int j = 0; j < ballots[0].length; j++ )
        {
            int[] ballot = new int[ballots.length];
            for ( int i = 0; i < ballots.length; i++ )
            {
                ballot[i] = ballots[i][j];
            }
            Queue<Candidate> q = new LinkedList<Candidate>();
            for ( int i = 1; i <= ballot.length; i++ )
            {
                for ( int spot = 0; spot < ballot.length; spot++ )
                {
                    if ( ballot[spot] == i )
                    {
                        q.add( candList.get( spot ) );
                    }
                }
            }
            list.add( q );
        }
        r = new ResultScreen( "electionName",
            new AlternativeElection( candList, list ) );
        r.setVisible( true );
    }


    private Queue<Candidate> sorted()
    {
        return null;
    }


    /**
     * Main method, creates an object.
     * 
     * @param args
     *            not used
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main( String[] args )
        throws IllegalAccessException,
        InstantiationException,
        ClassNotFoundException
    {
        Result r = new Result();
    }

}
