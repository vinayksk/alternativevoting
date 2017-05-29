package alternativevoting;

import java.util.*;

/**
 * Created by Andrew on 5/25/2017.
 */
public class Result
{
    ResultScreen r;

    public Result()
    {
        Scanner in = new Scanner( System.in );
        System.out.println( "Which election do we want results for?" );
        // here we get all the ballot information
        Candidate bob = new Candidate("bob");
        Candidate joe = new Candidate("joe");
        Candidate lin = new Candidate("lin");

        LinkedList<Queue<Candidate>> list = new LinkedList<Queue<Candidate>>();
        ArrayList<Candidate> candList = new ArrayList<Candidate>();
        candList.add(bob);
        candList.add(joe);
        candList.add(lin);

        Queue<Candidate> ballot1 = new LinkedList<Candidate>();
        ballot1.add(bob);
        ballot1.add(joe);
        list.add(ballot1);

        Queue<Candidate> ballot4 = new LinkedList<Candidate>();
        ballot4.add(bob);
        list.add(ballot4);

        Queue<Candidate> ballot5 = new LinkedList<Candidate>();
        ballot5.add(bob);
        list.add(ballot5);

        Queue<Candidate> ballot2 = new LinkedList<Candidate>();
        ballot2.add(lin);
        ballot2.add(bob);
        ballot2.add(joe);
        list.add(ballot2);

        Queue<Candidate> ballot3 = new LinkedList<Candidate>();
        ballot3.add(bob);
        list.add(ballot3);

        // the above is just a filler for now

        r = new ResultScreen("electionName", new AlternativeElection(candList, list));
        r.setVisible(true);
    }

    public static void main(String[] args)
    {
        Result r = new Result();
    }

}
