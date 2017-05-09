package alternativevoting;

import java.util.*;


public class Ballot
{ 
    private ArrayList<Candidate> list;


    public Ballot()
    {
        list = new ArrayList<Candidate>();
    }


    public void add( Candidate c )
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
