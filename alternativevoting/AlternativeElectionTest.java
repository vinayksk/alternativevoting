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


        q2.add( bob );
        q2.add( alice );
        q2.add( charlie );
        map.add( q2 );
        Queue<Candidate> q3 = new LinkedList<Candidate>();

        q3.add( charlie );
        q3.add( bob );
        q3.add( alice );
        map.add( q3 );
        Queue<Candidate> q4 = new LinkedList<Candidate>();

        q4.add( charlie );
        q4.add( bob );
        q4.add( alice );
        map.add( q4 );
        Queue<Candidate> q5 = new LinkedList<Candidate>();
        q5.add( alice );
        q5.add( charlie );
        q5.add( bob );
        map.add( q5);
        AlternativeElection a = new AlternativeElection( list, map );
        System.out.println( a.eliminateCandidate() );
        System.out.println( a.eliminateCandidate() );
    }
}