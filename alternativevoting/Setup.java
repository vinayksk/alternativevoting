package alternativevoting;

import java.util.*;
import java.io.*;


public class Setup
{

    private ArrayList<Candidate> names;


    public Setup()
    {
        Scanner in = new Scanner( System.in );
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
        System.out.println( names );
    }


    public void create()
    {

    }


    public static void main( String[] a )
    {
        Setup s = new Setup();

    }
}
