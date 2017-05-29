
// package alternativevoting;

import java.util.*;


public class AlternativeElection
{
    private ArrayList<Candidate> candList;

    private LinkedList<Queue<Candidate>> map;

    private HashSet<Candidate> set;


    public AlternativeElection(
        ArrayList<Candidate> candList,
        LinkedList<Queue<Candidate>> map )
    {
        this.candList = candList;
        this.map = map;
        set = new HashSet<Candidate>();
    }


    public LinkedList<Queue<Candidate>> getBallots()
    {
        return map;
    }


    public ArrayList<Candidate> eliminateCandidate()
    {
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
        return candList;
    }
}