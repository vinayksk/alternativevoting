package alternativevoting;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ResultScreen extends JFrame
{
    BarChart results;

    FinalActionButtons buttons;

    AlternativeElection a;

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

    public AlternativeElection getAlternativeElection()
    {
        return a;
    }

    public void updateBarChart(ArrayList<Candidate> list) {
        results.setCandidateList(list);
        results.update();
    }
}
