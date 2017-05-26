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


    public Candidate( String name, int votes )
    {
        this.votes = votes;
        this.name = name;
    }


    public int getVotes()
    {
        return votes;
    }


    public String toString()
    {
        return name;
    }


    public String getName()
    {
        return name;
    }


    public void changeVotes( int v )
    {
        votes += v;
    }


    public int compareTo( Candidate other )
    {
        return votes - other.getVotes();
    }
}
