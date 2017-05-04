package alternativevoting;

import java.util.*;


public class Ballot
{
    ArrayList<Candidate> list;

    String voter;


    public Ballot( String name )
    {
        list = new ArrayList<Candidate>();
    }

    public void addCandidate( Candidate c )
    {
        list.add( c );
    }
}
