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
        LinkedList<Queue<Candidate>> list = new LinkedList<Queue<Candidate>>();
<<<<<<< HEAD

=======
>>>>>>> a174fdf65577c0c4505a5d35bc6a91cfba2f4eb6
        int[][] ballots = a.request(str);
        for(int j=0;j<ballots[0].length;j++)
        {
            int[] ballot = new int[ballots.length];
            for(int i=0;i<ballots.length;i++)
            {
                ballot[i] = ballots[i][j];
            }
            Queue<Candidate> q = new LinkedList<Candidate>();
        }
<<<<<<< HEAD

=======
>>>>>>> a174fdf65577c0c4505a5d35bc6a91cfba2f4eb6
        r = new ResultScreen("electionName", new AlternativeElection(candList, list));
        r.setVisible(true);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Result r = new Result();
    }

}
