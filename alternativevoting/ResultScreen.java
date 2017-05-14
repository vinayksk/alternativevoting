package alternativevoting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ResultScreen extends JFrame implements ActionListener
{
    BarChart results;

    FinalActionButtons buttons;

    BallotStats b;


    public ResultScreen( String electionName, BallotStats b )
    {
        super( electionName );
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        this.b = b;
        c.add( b, BorderLayout.WEST );
        buttons = new FinalActionButtons();
        c.add( buttons, BorderLayout.SOUTH );
       
        this.setBounds( 100, 100, 700, 700 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setVisible( true );
    }


    public void actionPerformed( ActionEvent e )
    {
        buttons.actionPerformed( e );
    }
}
