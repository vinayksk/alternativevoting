package alternativevoting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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

        doneButton = new JButton( "Done with Elimination" );
        doneButton.setPreferredSize( new Dimension( 200, 100 ) );
        doneButton.addActionListener( this );
        add( doneButton );
    }

    public void setResultScreen(ResultScreen r)
    {
        this.r = r;
    }

    public void actionPerformed( ActionEvent e )
    {
        JButton button = (JButton)e.getSource();
        if ( button.getText().equals( "Eliminate a Candidate" ) )
        {
            String str = r.getAlternativeElection().eliminateCandidate();
            System.out.println("eliminated candidate " + str);
            r.updateBarChart(r.getAlternativeElection().getVotes());
        }
        else if(button.getText().equals("Done with Elimination"))
        {
            System.out.println("The winners are: \n");
            ArrayList<Candidate> list = r.getAlternativeElection().getCandidateList();
            for(int i=0;i<list.size();i++)
            {
                System.out.println(list.get(i).getName());
            }
        }
    }
}
