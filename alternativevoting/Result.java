package alternativevoting;

import java.util.*;

/**
 * Created by Andrew on 5/25/2017.
 */
public class Result
{
    ResultScreen r;

    public Result() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Scanner in = new Scanner( System.in );
        System.out.println( "Which election do we want results for?" );
        String str = in.nextLine();
        heroku a = new heroku();
        ArrayList<String> candNames = a.retrieve(str);
        ArrayList<Candidate> candList = new ArrayList<Candidate>();
        for(int i=0;i<candNames.size();i++)
        {
            candList.add(new Candidate(candNames.get(i)));
        }
        LinkedList<Queue<Candidate>> list = new LinkedList<Queue<Candidate>();
        int[][] ballots = a.request(str);

        r = new ResultScreen("electionName", new AlternativeElection(candList, list));
        r.setVisible(true);
    }

    public static void main(String[] args)
    {
        Result r = new Result();
    }

}
