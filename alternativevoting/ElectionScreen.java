package alternativevoting;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class ElectionScreen extends JFrame
{
    public ElectionScreen()
    {
        super( "Vote now on your phones!" );
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        ArrayList<Candidate> can = new ArrayList<Candidate>();
        can.add( new Candidate( "Jeffrey", 12 ) );
        can.add( new Candidate( "Austin", 2 ) );
        can.add( new Candidate( "De Facto", 3 ) );
        can.add( new Candidate( "Mathew", 23 ) );
        can.add( new Candidate( "Mattthew", 13 ) );
        BarChart chart = new BarChart( can );
        c.add( chart, BorderLayout.CENTER );
        VisualBallot b = new VisualBallot( chart );
        c.add( b, BorderLayout.SOUTH );
        ActionButtons stuff = new ActionButtons( b );
        c.add( stuff, BorderLayout.EAST );
        ArrayList<Ballot> bal = new ArrayList<Ballot>();
        
        
    }


    public static void main( String[] args )
    {
        ElectionScreen w = new ElectionScreen();
        w.setBounds( 100, 100, 700, 700 );
        w.setDefaultCloseOperation( EXIT_ON_CLOSE );
        w.setVisible( true );
        
    }
}
