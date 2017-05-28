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
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        Candidate bob = new Candidate("bob", 3);
        list.add(bob);
        Candidate joe = new Candidate("joe", 4);
        list.add(joe);
        Candidate lin = new Candidate("lin", 5);
        list.add(lin);

        HashMap<String, ArrayList<Candidate>> map = new HashMap<String, ArrayList<Candidate>>();
        ArrayList<Candidate> ballot1 = new ArrayList<Candidate>();
        ballot1.add(bob);
        ballot1.add(joe);
        map.put("kappa", ballot1);

        ArrayList<Candidate> ballot2 = new ArrayList<Candidate>();
        ballot2.add(lin);
        ballot2.add(bob);
        ballot2.add(joe);
        map.put("kappa2", ballot2);

        ArrayList<Candidate> ballot3 = new ArrayList<Candidate>();
        ballot3.add(bob);
        map.put("kappa3", ballot3);
        // the above is just a filler for now


        r = new ResultScreen("electionName", new AlternativeElection(list, map));
        r.setVisible(true);
    }

    public static void main(String[] args)
    {
        Result r = new Result();
    }

}
