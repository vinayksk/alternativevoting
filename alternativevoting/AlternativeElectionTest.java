package alternativevoting;

import java.util.*;


public class AlternativeElectionTest
{
    public static void main( String[] args )
    {
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        Candidate alice = new Candidate( "Alice" );
        Candidate bob = new Candidate( "Bob" );
        Candidate charlie = new Candidate( "Charlie" );
        list.add( alice );
        list.add( bob );
        list.add( charlie );
        LinkedList<Queue<Candidate>> map = new LinkedList<Queue<Candidate>>();
        Queue<Candidate> q = new LinkedList<Candidate>();
        q.add( alice );
        q.add( bob );
        q.add( charlie );
        map.add( q );
        Queue<Candidate> q2 = new LinkedList<Candidate>();
        q2.add( alice );
        q2.add( charlie );
        q2.add( bob );
        map.add( q2 );
        AlternativeElection a = new AlternativeElection( list, map );
        System.out.println( a.eliminateCandidate() );
    }
}