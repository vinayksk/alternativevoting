package alternativevoting;

import java.util.*;


public class BallotStats
{
    public static int[][] prefTable(LinkedList<Queue<Candidate>> list, ArrayList<Candidate> cands)
    {
        int[][] table = new int[cands.size()][cands.size()];
    for(Queue<Candidate> cand: list)
    {
        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[0].length;j++)
            {
                if(i != j && preferred(cand, cands.get(i), cands.get(j)))
                {
                    table[i][j]++;
                }
            }
        }
    }
        return table;
    }


    // returns true if a before b in list, false otherwise
    private static boolean preferred(Queue<Candidate> list, Candidate a, Candidate b)
    {
        Queue<Candidate> copy = list;
        for(int i=0;i<copy.size();i++)
        {
            if(copy.peek().equals(a.getName()))
            {
                return true;
            }
            else if(copy.peek().getName().equals(b.getName()))
            {
                return false;
            }
            list.remove();
        }
        return false;
    }

    public static double[][] pollProbabilities(LinkedList<Queue<Candidate>> map, ArrayList<Candidate> cands)
    {
        double[][] table = new double[cands.size()][cands.size()];
        int[][] table2 = prefTable(map, cands);
        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[0].length;j++)
            {
                table[i][j] = percentageWin(table2[i][j], table2[j][i]);
            }
        }
        return table;
    }
    public static double percentageWin(int votes1, int votes2)
    {
        if(votes1 == 0 && votes2 == 0)
        {
            return 50;
        }
        else if (votes1 == 0)
        {
            return 0;
        }
        else if(votes2 == 0)
        {
            return 100;
        }
        double prop = (double)(votes1)/(votes1+votes2);
        double stdDev = Math.sqrt(prop * (1-prop) / (votes1 + votes2));
        double zScore = (prop - 0.5)/stdDev;
        return 100 * normpdf(zScore);
    }

    public static double normpdf(double zscore)
    {
        if(zscore >= 3)
        {
            return (double)(1)/(1+Math.exp(0.000345*zscore - 0.039547*Math.pow(zscore, 3) - 1.604326 * Math.pow(zscore, 5)));
        }
        else if(zscore <= -3)
        {
            return 1 - normpdf(-zscore);
        }
        double ret = 0;
        int pos = 1;
        for(int i=0;i<13;i++)
        {
            ret += pos * (double)Math.pow(zscore, 2*i + 1) / Math.pow(2, i) / factorial(i) / (2*i+1);
            pos *= -1;
        }
        return 0.5 + ret / Math.sqrt(2*Math.PI);
    }

    private static long factorial(int n)
    {
        if(n<=1)
        {
            return 1;
        }
        if(n>=13)
        {
            return Long.MAX_VALUE;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args)
    {
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

        Queue<Candidate> ballot2 = new LinkedList<Candidate>();
        ballot2.add(lin);
        ballot2.add(bob);
        ballot2.add(joe);
        list.add(ballot2);

        Queue<Candidate> ballot3 = new LinkedList<Candidate>();
        ballot3.add(bob);
        list.add(ballot3);


        double[][] pref = pollProbabilities(list, candList);
        for(int i=0;i<pref.length;i++)
        {
            for(int j=0;j<pref[0].length;j++)
            {
                System.out.print(pref[i][j] + " ");
            }
            System.out.println();
        }

    }
}
