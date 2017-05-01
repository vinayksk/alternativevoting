package alternativevoting;

public class Candidate
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


    public String getName()
    {
        return name;
    }


    public void changeVotes( int v )
    {
        votes += v;
    }
}
