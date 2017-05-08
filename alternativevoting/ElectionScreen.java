package alternativevoting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;


public class ElectionScreen extends JFrame implements ActionListener
{
    LinkedList<Candidate> ballots;

    BarChart chart;

    VisualBallot b;

    ActionButtons a;


    public ElectionScreen()
    {
        super( "Vote" );
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        list.add( new Candidate( "Jeffrey", 12 ) );
        list.add( new Candidate( "Austin", 2 ) );
        list.add( new Candidate( "De Facto", 3 ) );
        list.add( new Candidate( "Mathew", 23 ) );
        list.add( new Candidate( "Mattthew", 13 ) );
        chart = new BarChart( list );
        c.add( chart, BorderLayout.CENTER );
        b = new VisualBallot( chart );
        c.add( b, BorderLayout.SOUTH );
        a = new ActionButtons( b );
        c.add( a, BorderLayout.EAST );
    }


    public static void main( String[] args )
    {
        ElectionScreen w = new ElectionScreen();
        w.setBounds( 100, 100, 700, 700 );
        w.setDefaultCloseOperation( EXIT_ON_CLOSE );
        w.setVisible( true );
    }


    public void actionPerformed( ActionEvent e )
    {
        b.actionPerformed( e );
    }
}
