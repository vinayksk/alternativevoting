package alternativevoting;

import java.util.*;


public class AlternativeElection
{
    private ArrayList<Candidate> candList;

    private HashMap<String, Queue<Candidate>> map;

    private HashSet<Candidate> set;


    public AlternativeElection(
        ArrayList<Candidate> candList,
        HashMap<String, Queue<Candidate>> map )
    {
        this.candList = candList;
        this.map = map;
        set = new HashSet<Candidate>();
    }


    public ArrayList<Candidate> getCandidateList()
    {
        return candList;
    }


    public HashMap<String, Queue<Candidate>> getBallots()
    {
        return map;
    }


    public Candidate eliminateCandidate()
    {
        for ( Queue<Candidate> list : map.values() )
        {
            if ( !list.isEmpty() )
            {
                list.peek().increment();
            }
        }
        Collections.sort( candList );
        Candidate remove = candList.remove( 0 );
        set.add( remove );
        for ( Queue<Candidate> list : map.values() )
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
        return remove;
    }
}