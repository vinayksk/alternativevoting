package alternativevoting;

import java.util.*;


public class Ballot
{
    private ArrayList<Candidate> list;


    public Ballot()
    {
        list = new ArrayList<Candidate>();
    }

<<<<<<< HEAD
    public void addCandidate( Candidate c )
=======

    public void add( Candidate c )
>>>>>>> 0356f5e8bb2f8b419456f1a67fa882d119d0cd85
    {
        list.add( c );
    }


    public ArrayList<Candidate> getList()
    {
        return list;
    }
    
    public String toString()
    {
        return list.toString();
    }
}
