package alternativevoting;
 
import static org.junit.Assert.*;
 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
 
import org.junit.Test;
 
 
/**
 * Tests Alternative Election and Candidate classes
 *
 * @author Jeffrey Tao
 * @version May 29, 2017
 * @author Assignment: Final Project
 * 
 * @author Sources: None
 *
 */
public class JUAlternativeVotingTest
{
 
    private Candidate cand;
 
 
    @Test
    public void AlternativeElectionConstructor()
    {
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        LinkedList<Queue<Candidate>> map = new LinkedList<Queue<Candidate>>();
        AlternativeElection a = new AlternativeElection( list, map );
        assertNotNull( a );
    }
 
 
    @Test
    public void AlternativeElectionGetCandList()
    {
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        LinkedList<Queue<Candidate>> map = new LinkedList<Queue<Candidate>>();
        AlternativeElection a = new AlternativeElection( list, map );
        assertEquals( list, a.getCandList() );
    }
 
 
    @Test
    public void AlternativeElectionGetBallots()
    {
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        LinkedList<Queue<Candidate>> map = new LinkedList<Queue<Candidate>>();
        AlternativeElection a = new AlternativeElection( list, map );
        assertEquals( map, a.getBallots() );
    }
 
 
    @Test
    public void AlternativeElectionEliminateCandidate()
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
        map.add( q2 );
        Queue<Candidate> q3 = new LinkedList<Candidate>();
        q3.add( charlie );
        map.add( q3 );
        AlternativeElection a = new AlternativeElection( list, map );
        assertEquals( a.eliminateCandidate().get( 0 ), charlie );
        assertEquals( a.eliminateCandidate().get( 0 ), alice );
    }
 
 
    @Test
    public void CandidateConstructor()
    {
        cand = new Candidate( "name" );
        assertNotNull( cand );
    }
 
 
    @Test
    public void CandidateToString()
    {
        cand = new Candidate( "name" );
        cand.increment();
        assertEquals( cand.toString(), "name 1" );
    }
 
 
    @Test
    public void CandidateGetVotes()
    {
        cand = new Candidate( "name" );
        assertEquals( cand.getVotes(), 0 );
    }
 
 
    @Test
    public void CandidateGetName()
    {
        cand = new Candidate( "name" );
        assertEquals( cand.getName(), "name" );
    }
 
 
    @Test
    public void CandidateIncrement()
    {
        cand = new Candidate( "name" );
        cand.increment();
        assertEquals( cand.getVotes(), 1 );
    }
 
 
    @Test
    public void CandidateReset()
    {
        cand = new Candidate( "name" );
        cand.increment();
        cand.reset();
        assertEquals( cand.getVotes(), 0 );
    }
 
 
    @Test
    public void CandidateCompareTo()
    {
        cand = new Candidate( "name" );
        Candidate otherCand = new Candidate( "other name" );
        assertTrue( cand.compareTo( otherCand ) == 0 );
        cand.increment();
        assertTrue( cand.compareTo( otherCand ) > 0 );
    }
 
 
    @Test
    public void BallotStatsPrefTable()
    {
 
        Candidate bob = new Candidate( "bob" );
        Candidate joe = new Candidate( "joe" );
        Candidate lin = new Candidate( "lin" );
 
        LinkedList<Queue<Candidate>> list = new LinkedList<Queue<Candidate>>();
        ArrayList<Candidate> candList = new ArrayList<Candidate>();
        candList.add( bob );
        candList.add( joe );
        candList.add( lin );
 
        Queue<Candidate> ballot1 = new LinkedList<Candidate>();
        ballot1.add( bob );
        ballot1.add( joe );
        list.add( ballot1 );
 
        Queue<Candidate> ballot2 = new LinkedList<Candidate>();
        ballot2.add( lin );
        ballot2.add( bob );
        ballot2.add( joe );
        list.add( ballot2 );
 
        Queue<Candidate> ballot3 = new LinkedList<Candidate>();
        ballot3.add( bob );
        list.add( ballot3 );
 
        int[][] pref = BallotStats.prefTable( list, candList );
        int[][] test = { { 0, 3, 2 }, { 0, 0, 0, }, { 1, 1, 0 } };
        boolean correct = true;
        for ( int i = 0; i < pref.length; i++ )
        {
            for ( int j = 0; j < pref[0].length; j++ )
            {
                if ( pref[i][j] != test[i][j] )
                {
                    correct = false;
                }
            }
        }
        assertTrue( correct );
    }
 
 
    @Test
    public void BallotStatsPrefTablePerc()
    {
 
        Candidate bob = new Candidate( "bob" );
        Candidate joe = new Candidate( "joe" );
        Candidate lin = new Candidate( "lin" );
 
        LinkedList<Queue<Candidate>> list = new LinkedList<Queue<Candidate>>();
        ArrayList<Candidate> candList = new ArrayList<Candidate>();
        candList.add( bob );
        candList.add( joe );
        candList.add( lin );
 
        Queue<Candidate> ballot1 = new LinkedList<Candidate>();
        ballot1.add( bob );
        ballot1.add( joe );
        list.add( ballot1 );
 
        Queue<Candidate> ballot2 = new LinkedList<Candidate>();
        ballot2.add( lin );
        ballot2.add( bob );
        ballot2.add( joe );
        list.add( ballot2 );
 
        Queue<Candidate> ballot3 = new LinkedList<Candidate>();
        ballot3.add( bob );
        list.add( ballot3 );
        double[][] pref2 = BallotStats.prefTablePerc( list, candList );
        double[][] test = { { 0.0, 100.0, 66.6 }, { 0.0, 0.0, 0.0, },
            { 33.3, 100.0, 0.0 } };
        boolean correct = true;
        for ( int i = 0; i < pref2.length; i++ )
        {
            for ( int j = 0; j < pref2[0].length; j++ )
            {

                if ( pref2[i][j] != test[i][j] )
                {
                    correct = false;
                }
            }
        }
        assertTrue( correct );
    }
}

