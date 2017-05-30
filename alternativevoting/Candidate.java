package alternativevoting;

/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author jeffr
 * @version May 29, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 *
 * @author Sources: None
 */
public class Candidate implements Comparable<Candidate>
{
    private int votes;

    private String name;


    /**
     * Constructs a Candidate with the specified name
     * 
     * @param name
     *            Name of the Candidate.
     */
    public Candidate( String name )
    {
        votes = 0;
        this.name = name;
    }


    /**
     * Returns number of votes the candidate has.
     * 
     * @return Returns votes variable
     */
    public int getVotes()
    {
        return votes;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return name + " " + votes;
    }


    /**
     * Returns name of candidate.
     * 
     * @return Returns name variable
     */
    public String getName()
    {
        return name;
    }


    /**
     * Adds 1 to vote count.
     */
    public void increment()
    {
        votes += 1;
    }


    /**
     * Sets vote count to 0;
     */
    public void reset()
    {
        votes = 0;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo( Candidate other )
    {
        return votes - other.getVotes();
    }

}
