package alternativevoting;

public class Candidate implements Comparable<Candidate>
{
    private int votes;

    private String name;


    public Candidate( String name )
    {
        votes = 0;
        this.name = name;
    }


    public int getVotes()
    {
        return votes;
    }


    public String toString()
    {
        return name + " " + votes;
    }


    public String getName()
    {
        return name;
    }


    public void increment()
    {
        votes += 1;
    }


    public void reset()
    {
        votes = 0;
    }


    public int compareTo( Candidate other )
    {
        return votes - other.getVotes();
    }


    public static void main( String[] args )
    {
    }
}
