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


    public FinalActionButtons()
    {

        eliminateButton = new JButton( "Eliminate a Candidate" );
        eliminateButton.setPreferredSize( new Dimension( 150, 40 ) );
        eliminateButton.addActionListener( this );
        add( eliminateButton );

        doneButton = new JButton( "Done with Elimination" );
        doneButton.setPreferredSize( new Dimension( 150, 40 ) );
        doneButton.addActionListener( this );
        add( doneButton );
    }


    public void actionPerformed( ActionEvent e )
    {
        
    }
}
