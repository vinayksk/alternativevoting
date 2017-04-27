package alternativevoting;

import java.util.ArrayList;


public class Position
{
    public ArrayList<Candidate> names;

    String name;


    public Position( String name )
    {
        this.name = name;
        names = new ArrayList<Candidate>();
    }


    public String getName()
    {
        return name;
    }
}