package alternativevoting;

import java.util.*;
import java.io.*;


public class Setup
{

    private ArrayList<Candidate> names;

    private String electionName;


    public Setup()
    {
        Scanner in = new Scanner( System.in );
        System.out.println( "What is the name of the election?" );
        electionName = in.nextLine();
        int count = 1;
        names = new ArrayList<Candidate>();
        System.out.println( "Enter the name of Candidate " + count + ":" );
        String str = in.nextLine();
        while ( !str.equals( "!" ) )
        {
            names.add( new Candidate( str ) );
            System.out.println( "Enter the name of Candidate " + ++count
                + " or \"!\" if there are no more candidates:" );
            str = in.nextLine();
        }
    }


    public void create()
    {

    }


    public static void main( String[] a )
    {
        Setup s = new Setup();

    }
}
