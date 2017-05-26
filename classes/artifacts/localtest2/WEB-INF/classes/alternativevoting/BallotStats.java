package alternativevoting;

import java.util.*;


public class BallotStats
{
    public static int[][] prefTable(HashSet<ArrayList<Candidate>> set, int numCands)
    {
        int[][] table = new int[numCands][numCands];
        return table;
    }

    public double[] pollProbabilities()
    {
        return null;
    }
    public static double percentageWin(int votes1, int votes2)
    {
        double prop = (double)(votes1)/(votes1+votes2);
        double stdDev = Math.sqrt(prop * (1-prop) / (votes1 + votes2));
        double zScore = (prop - 0.5)/stdDev;
        return 100 * normpdf(zScore);
    }

    public static double normpdf(double zscore)
    {
        double ret = 0;
        for(int i=0;i<Math.abs(Math.floor(10*zscore));i++)
        {
            ret += 2;
        }
        return ret / Math.sqrt(2*Math.PI);
    }

   // e^(-x^2/2) = sum((-1)^n)

    public static void main(String[] args)
    {
        System.out.println(normpdf(1.0));
        int votes1 = 123;
        int votes2 = 1234;
        System.out.println(percentageWin(votes1, votes2));
    }
}
