package alternativevoting;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class VisualBallot extends JPanel implements ActionListener
{

    ArrayList<Candidate> candList;

    ArrayList<JTextField> fields;

    ArrayList<JButton> buttons;

    BarChart b;

    int rankedCands = 0;


    public VisualBallot( BarChart chart )
    {
        b = chart;
        fields = new ArrayList<JTextField>();
        buttons = new ArrayList<JButton>();
        setBackground( Color.WHITE );
        candList = chart.getCandidateList();
        for ( int i = 0; i < candList.size(); i++ )
        {
            fields.add( new JTextField() );
            fields.get( i ).setPreferredSize( new Dimension( 40, 30 ) );
        }
        for ( int i = 0; i < candList.size(); i++ )
        {
            buttons.add( new JButton( candList.get( i ).getName() ) );
            buttons.get( i ).setPreferredSize( new Dimension( 80, 30 ) );
            buttons.get( i ).addActionListener( this );
        }
        for ( int i = 0; i < candList.size(); i++ )
        {
            this.add( fields.get( i ) );
            this.add( buttons.get( i ) );
        }
    }


    public void actionPerformed( ActionEvent e )
    {
        JButton button = (JButton)e.getSource();
        if ( indexOf( button ) >= 0 )
        {
            rankedCands++;
            fields.get( indexOf( button ) )
                .setText( Integer.toString( rankedCands ) );
        }
    }


    public int indexOf( JButton button )
    {
        for ( int i = 0; i < buttons.size(); i++ )
        {
            if ( buttons.get( i ).equals( button ) )
            {
                return i;
            }
        }
        return -1;
    }
}
