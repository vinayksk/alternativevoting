package alternativevoting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ActionButtons extends JPanel implements ActionListener
{
    private JButton clearButton, submitButton;

    private VisualBallot b;


    public ActionButtons( VisualBallot b )
    {
        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
        clearButton = new JButton( "Clear" );
        clearButton.setPreferredSize( new Dimension( 80, 80 ) );
        clearButton.addActionListener( this );
        add( clearButton );

        submitButton = new JButton( "Vote" );
        submitButton.setPreferredSize( new Dimension( 80, 80 ) );
        submitButton.addActionListener( this );
        add( submitButton );

        this.b = b;
    }


    public void actionPerformed( ActionEvent e )
    {
        JButton button = (JButton)e.getSource();
        if ( button.getText().equals( "Clear" ) )
        {
            for ( JTextField t : b.fields )
            {
                t.setText( "" );
            }
        }
    }
}
