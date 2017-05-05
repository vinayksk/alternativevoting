package alternativevoting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ActionButtons extends JPanel implements ActionListener
{
    private JButton clearButton, submitButton, calculateButton;

    private VisualBallot b;


    public ActionButtons( VisualBallot b )
    {
        clearButton = new JButton( "Clear" );
        clearButton.setPreferredSize( new Dimension( 80, 30 ) );
        clearButton.addActionListener( this );
        add( clearButton );

        submitButton = new JButton( "Vote" );
        submitButton.setPreferredSize( new Dimension( 80, 30 ) );
        submitButton.addActionListener( this );
        add( submitButton );

        calculateButton = new JButton( "Done" );
        calculateButton.setPreferredSize( new Dimension( 80, 30 ) );
        calculateButton.addActionListener( this );
        add( calculateButton );

        this.b = b;
    }


    public void actionPerformed( ActionEvent e )
    {
        
    }
}
