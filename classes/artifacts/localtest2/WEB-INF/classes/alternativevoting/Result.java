package alternativevoting;

import java.util.ArrayList;
import java.util.Scanner;

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
        list.add(new Candidate("Jeffrey", 3));
        list.add(new Candidate("Vinay", 4));
        list.add(new Candidate("Trevor", 5));
        // the above is just a filler for now
        r = new ResultScreen("electionName", list //, new AlternativeElection()
        );
        r.setVisible(true);
    }

    public static void main(String[] args)
    {
        Result r = new Result();
    }

}
