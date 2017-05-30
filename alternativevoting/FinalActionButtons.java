package alternativevoting;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FinalActionButtons extends JPanel implements ActionListener
{
    private JButton eliminateButton, doneButton;

    ResultScreen r;


    public FinalActionButtons()
    {
        eliminateButton = new JButton( "Eliminate a Candidate" );
        eliminateButton.setPreferredSize( new Dimension( 200, 100 ) );
        eliminateButton.addActionListener( this );
        add( eliminateButton );

        doneButton = new JButton( "Get Statistics" );
        doneButton.setPreferredSize( new Dimension( 200, 100 ) );
        doneButton.addActionListener( this );
        add( doneButton );
    }


    public void setResultScreen( ResultScreen r )
    {
        this.r = r;
    }


    public void actionPerformed( ActionEvent e )
    {
        JButton button = (JButton)e.getSource();
        if ( button.getText().equals( "Eliminate a Candidate" ) )
        {
            r.updateBarChart( r.getAlternativeElection().eliminateCandidate() );
        }
        else
        {
            Component frame = new JFrame( "Election statistics" );
            System.out.println();
            JOptionPane.showMessageDialog( frame,
                Arrays.deepToString( BallotStats.prefTable(
                    r.getAlternativeElection().getBallots(),
                    r.getAlternativeElection().getCandList() ) ) );
        }
    }
}
