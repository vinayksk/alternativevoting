package alternativevoting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VoterInfo extends JPanel
{
    JTextField voterName;


    public VoterInfo()
    {
        voterName = new JTextField();
        voterName.setPreferredSize( new Dimension( 80, 40 ) );
        this.add( voterName );
    }


    public String getVoterName()
    {
        return voterName.getText();
    }
}
