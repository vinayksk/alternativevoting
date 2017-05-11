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
        this.electionName = electionName;
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        candidates = a;
        chart = new BarChart( a );

        c.add( chart, BorderLayout.CENTER );
        b = new VisualBallot( chart );
        c.add( b, BorderLayout.SOUTH );

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
    }


    public ArrayList<Candidate> getCandidates()
    {
        return candidates;
    }


    public void actionPerformed( ActionEvent e )
    {
        b.actionPerformed( e );
    }
}
