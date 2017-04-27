package alternativevoting;

public interface Election
{
    
    Candidate processBallot( Ballot b );

    boolean existsWinner();
}
