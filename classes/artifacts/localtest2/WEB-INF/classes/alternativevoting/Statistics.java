package alternativevoting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by Andrew on 5/25/2017.
 */
public class Statistics extends JPanel implements ActionListener
{
    private JButton statButton, explainButton;
    ResultScreen r;

    public Statistics()
    {
        statButton = new JButton( "Get Statistics" );
        statButton.setPreferredSize( new Dimension( 200, 100 ) );
        statButton.addActionListener( this );
        add(statButton);

        explainButton = new JButton( "Explanation" );
        explainButton.setPreferredSize( new Dimension( 200, 100 ) );
        explainButton.addActionListener( this );
        add( explainButton );
    }

    public void setResultScreen(ResultScreen r)
    {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        if ( button.getText().equals( "Get Statistics" ) )
        {
            JFrame frame = new JFrame();
            JLabel text = new JLabel("text");
            JPanel panel = new JPanel();
            panel.add(text);
           // text.setText(BallotStats.method(r.getAlternativeElection()));
            frame.add(panel, BorderLayout.CENTER);
            frame.setBounds( 100, 100, 200, 200 );
            frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
            setVisible( true );
            frame.setVisible(true);
        }
    }
}
