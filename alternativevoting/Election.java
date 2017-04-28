package alternativevoting;

import java.util.*;


public interface Election
{
    Candidate BallotWinner( Ballot b );


    boolean existsWinner();


    String currentResults();
}
