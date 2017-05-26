package alternativevoting;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class ResultScreen extends JInternalFrame implements ActionListener
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
        buttons = new FinalActionButtons(this.b);
        c.add( buttons, BorderLayout.SOUTH );
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        list.add(new Candidate("Jeffrey", 3));
        list.add(new Candidate("Vinay", 4));
       results = new BarChart(list);
       c.add(results, BorderLayout.CENTER);


        this.setBounds( 100, 100, 700, 700 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setVisible( true );
    }


    public void actionPerformed( ActionEvent e )
    {
        buttons.actionPerformed( e );
    }
}
