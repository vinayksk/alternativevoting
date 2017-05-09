package alternativevoting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;


public class ElectionScreen extends JFrame implements ActionListener
{
    ArrayList<Candidate> candidates;

    String electionName;

    BarChart chart;

    VisualBallot b;

    ActionButtons buttons;

    VoterInfo v;


    public ElectionScreen( ArrayList<Candidate> a, String electionName )
    {
        super( electionName );
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
<<<<<<< HEAD
        ArrayList<Candidate> can = new ArrayList<Candidate>();
        can.add( new Candidate( "Jeffrey", 12 ) );
        can.add( new Candidate( "Austin", 2 ) );
        can.add( new Candidate( "De Facto", 3 ) );
        can.add( new Candidate( "Mathew", 23 ) );
        can.add( new Candidate( "Mattthew", 13 ) );
        BarChart chart = new BarChart( can );
=======
        candidates = a;
        chart = new BarChart( a );
>>>>>>> e69810b1c31f9dadbbc72f3bbfbe652d8dedd6ed
        c.add( chart, BorderLayout.CENTER );
        b = new VisualBallot( chart );
        c.add( b, BorderLayout.SOUTH );
<<<<<<< HEAD
        ActionButtons stuff = new ActionButtons( b );
        c.add( stuff, BorderLayout.EAST );
        ArrayList<Ballot> bal = new ArrayList<Ballot>();
        
        
=======
        v = new VoterInfo();
        c.add( v, BorderLayout.WEST );
        buttons = new ActionButtons( b, v );
        c.add( buttons, BorderLayout.EAST );
        this.setBounds( 100, 100, 700, 700 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setVisible( true );
    }


    public String getElectionName()
    {
        return electionName;
>>>>>>> e69810b1c31f9dadbbc72f3bbfbe652d8dedd6ed
    }


    public void actionPerformed( ActionEvent e )
    {
<<<<<<< HEAD
        ElectionScreen w = new ElectionScreen();
        w.setBounds( 100, 100, 700, 700 );
        w.setDefaultCloseOperation( EXIT_ON_CLOSE );
        w.setVisible( true );
        
=======
        b.actionPerformed( e );
>>>>>>> e69810b1c31f9dadbbc72f3bbfbe652d8dedd6ed
    }
}
