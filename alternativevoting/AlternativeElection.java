package alternativevoting;

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
        for ( Queue<Candidate> list : map )
        {
            if ( !list.isEmpty() )
            {
                list.peek().increment();
            }
        }
        Collections.sort( candList );
        Candidate remove = candList.remove( 0 );
        set.add( remove );
        for ( Queue<Candidate> list : map )
        {
            while ( !list.isEmpty() )
            {
                if ( set.contains( list.peek() ) )
                {
                    list.remove();
                }
            }
        }
        for ( Candidate c : candList )
        {
            c.reset();
        }
        return candList;
    }
}