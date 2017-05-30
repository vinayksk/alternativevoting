package alternativevoting;

import java.util.*;


/**
 * Provides ballot statistics.
 *
 * @author Andrew, Jeffrey
 * @version May 29, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 *
 * @author Sources: None
 */
public class BallotStats
{

    /**
     * Returns a preference table. prefTable[i][j] has the number of ballots
     * that prefer candidate i to candidate j in cands list
     * 
     * @param list
     *            list of ballots
     * @param cands
     *            list of candidates
     * @return returns int[][] containing preference counts
     */
    public static int[][] prefTable(
        LinkedList<Queue<Candidate>> list,
        ArrayList<Candidate> cands )
    {
        int[][] table = new int[cands.size()][cands.size()];
        for ( Queue<Candidate> cand : list )
        {
            for ( int i = 0; i < table.length; i++ )
            {
                for ( int j = 0; j < table[0].length; j++ )
                {
                    if ( i != j
                        && preferred( cand, cands.get( i ), cands.get( j ) ) )
                    {
                        table[i][j]++;
                    }
                }
            }
        }
        return table;
    }


    /**
     * Returns a preference table. prefTable[i][j] has the percentage of ballots
     * that prefer candidate i to candidate j in cands list, relative to the
     * percentage of ballots that prefer candidate j to candidate i. Rounds to
     * the nearest tenth of a percent.
     * 
     * @param list
     *            list of ballots
     * @param cands
     *            list of candidates
     * @return returns int[][] containing preference percentages
     */
    public static double[][] prefTablePerc(
        LinkedList<Queue<Candidate>> list,
        ArrayList<Candidate> cands )
    {
        int[][] table = prefTable( list, cands );
        double[][] table2 = new double[cands.size()][cands.size()];
        for ( int i = 0; i < table.length; i++ )
        {
            for ( int j = i; j < table[0].length; j++ )
            {
                if ( i != j )
                {
                    int sum = table[i][j] + table[j][i];
                    if ( sum != 0 )
                    {
                        table2[i][j] = (int)( 1000.0 * table[i][j] / sum )
                            / 10.0;
                        table2[j][i] = (int)( 1000.0 * table[j][i] / sum )
                            / 10.0;
                    }
                }
            }
        }
        return table2;
    }


    // returns true if a before b in list, false otherwise
    private static boolean preferred(
        Queue<Candidate> list,
        Candidate a,
        Candidate b )
    {
        Queue<Candidate> copy = new LinkedList<Candidate>( list );
        for ( int i = 0; i < copy.size(); i++ )
        {
            if ( copy.peek().getName().equals( a.getName() ) )
            {
                return true;
            }
            else if ( copy.peek().getName().equals( b.getName() ) )
            {
                return false;
            }
            copy.remove();
        }
        return false;
    }

}