package alternativevoting;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates a ResultScreen object.
 *
 * @author Andrew Lin
 * @version May 29, 2017
 * @author Assignment: Final Project
 *
 * @author Sources: None
 *
 */
public class ResultScreen extends JFrame
{
    private BarChart results;

    private FinalActionButtons buttons;

    private AlternativeElection a;

    /**
     * Creates a new result screen.
     * @param electionName name of election
     * @param a the alternativeelection to use
     */
    public ResultScreen( String electionName, AlternativeElection a)
    {
        super( electionName );
        Container c = getContentPane();
        c.setBackground( Color.WHITE );

        this.a = a;

        buttons = new FinalActionButtons();
        c.add( buttons, BorderLayout.SOUTH );
        buttons.setResultScreen(this);

        results = new BarChart(a.getCandList());
        c.add(results, BorderLayout.CENTER);

        this.setBounds( 100, 100, 1000, 1000 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setVisible( true );
    }

    /**
     * Gets alternative election
     * @return alternative election
     */
    public AlternativeElection getAlternativeElection()
    {
        return a;
    }

    /**
     * Updates bar chart.
     * @param list New list of candidates to update with
     */
    public void updateBarChart(ArrayList<Candidate> list) {
        results.setCandidateList(list);
        results.update();
    }
}
