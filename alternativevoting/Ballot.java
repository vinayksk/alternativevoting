package alternativevoting;

import java.util.*;


public class Ballot
{
    ArrayList<Candidate> list;


    public Ballot()
    {
        list = new ArrayList<Candidate>();
    }


    public void addCandidate( Candidate c )
    {
        list.add( c );
    }
}
