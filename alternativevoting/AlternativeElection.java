
package alternativevoting;

import java.util.*;


/**
 * Provides methods for running each round of eliminating a candidate.
 *
 * @author jeffr
 * @version May 29, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 *
 * @author Sources: None
 */
public class AlternativeElection
{
    private ArrayList<Candidate> candList;

    private LinkedList<Queue<Candidate>> map;

    private HashSet<Candidate> set;


    /**
     * Constructs an AlternativeElection object with a list of candidates and
     * list of ballots
     * 
     * @param candList
     *            ArrayList that stores candidates
     * @param map
     *            LinkedList of Queues that stores ballots
     */
    public AlternativeElection(
        ArrayList<Candidate> candList,
        LinkedList<Queue<Candidate>> map )
    {
        this.candList = candList;
        this.map = map;
        set = new HashSet<Candidate>();

        for ( Queue<Candidate> list : map )
        {
            if ( !list.isEmpty() )
            {
                list.peek().increment();
            }
        }
    }


    /**
     * Returns the list of ballots.
     * 
     * @return Returns map variable
     */
    public LinkedList<Queue<Candidate>> getBallots()
    {
        return map;
    }


    /**
     * Returns the list of candidates.
     * 
     * @return Returns candList variable.
     */
    public ArrayList<Candidate> getCandList()
    {
        return candList;
    }


    /**
     * Tallies up first choice votes for each ballot, eliminates least popular
     * candidate(s), and returns modified candidate list.
     * 
     * @return Returns the modified candList after one round of candidates has
     *         been eliminated.
     */
    public ArrayList<Candidate> eliminateCandidate()
    {
        Collections.sort( candList );
        int min = candList.get( 0 ).getVotes();
        int max = candList.get( candList.size() - 1 ).getVotes();
        if ( min == max )
        {
            return candList;
        }
        while ( candList.get( 0 ).getVotes() == min )
        {
            Candidate remove = candList.remove( 0 );
            set.add( remove );
        }
        for ( Queue<Candidate> list : map )
        {
            while ( !list.isEmpty() && set.contains( list.peek() ) )
            {
                list.remove();
            }
        }
        for ( Candidate c : candList )
        {
            c.reset();
        }
        for ( Queue<Candidate> list : map )
        {
            if ( !list.isEmpty() )
            {
                list.peek().increment();
            }
        }
        return candList;
    }
}