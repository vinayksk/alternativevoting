package alternativevoting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class FinalActionButtons extends JPanel implements ActionListener
{
    private JButton eliminateButton, doneButton;
    BallotStats b;

    public FinalActionButtons(BallotStats b)
    {
        this.b = b;
        eliminateButton = new JButton( "Eliminate a Candidate" );
        eliminateButton.setPreferredSize( new Dimension( 200, 40 ) );
        eliminateButton.addActionListener( this );
        add( eliminateButton );

        doneButton = new JButton( "Done with Elimination" );
        doneButton.setPreferredSize( new Dimension( 200, 40 ) );
        doneButton.addActionListener( this );
        add( doneButton );
    }


    public void actionPerformed( ActionEvent e )
    {
        JButton button = (JButton)e.getSource();
        if ( button.getText().equals( "Eliminate a Candidate" ) )
        {

        }
    }
}
