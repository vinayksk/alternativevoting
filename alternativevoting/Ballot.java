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

>>>>>>> e69810b1c31f9dadbbc72f3bbfbe652d8dedd6ed
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
