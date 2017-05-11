package alternativevoting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VoterInfo extends JPanel
{
    JTextField voterName;

    JTextField age;

    JLabel description;


    public VoterInfo()
    {
        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );

        voterName = new JTextField();
        voterName.setText( "Voter name?" );
        voterName.setPreferredSize( new Dimension( 80, 40 ) );
        this.add( voterName );

        age = new JTextField();
        age.setText( "Age?" );
        age.setPreferredSize( new Dimension( 80, 40 ) );
        this.add( age );

        description = new JLabel();
        description.setPreferredSize( new Dimension( 80, 40 ) );
        description.setText(
            "This will only be used for statistical purposes. By the way, please don't put any numbers in your name!" );
        this.add( description );
    }


    public String getVoterName()
    {
        if ( voterName.getText().equals( "Voter name?" ) )
        {
            return "";
        }
        return voterName.getText();
    }


    public int getAge()
    {
        if ( this.isNumeric( age.getText() ) )
        {
            return Integer.parseInt( age.getText() );
        }
        return -1;
    }


    private boolean isNumeric( String str )
    {
        for ( int i = 0; i < str.length(); i++ )
        {
            if ( !Character.isDigit( str.charAt( i ) ) )
            {
                return false;
            }
        }
        return true;
    }
}
