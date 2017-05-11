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
=======

>>>>>>> 09876d5830cffbf5e4e77b02a384ccf41f83bc99
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
