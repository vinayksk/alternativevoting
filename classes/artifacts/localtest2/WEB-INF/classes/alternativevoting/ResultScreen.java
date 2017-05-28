package alternativevoting;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ResultScreen extends JFrame
{
    BarChart results;

    FinalActionButtons buttons;

    Statistics stats;

    // AlternativeElection a;

    HashSet<ArrayList<Candidate>> set;

    public ResultScreen( String electionName, ArrayList<Candidate> list //, AlternativeElection a
    )
    {
        // this.a = a;
        super( electionName );
        Container c = getContentPane();
        c.setBackground( Color.WHITE );

        buttons = new FinalActionButtons();
        c.add( buttons, BorderLayout.SOUTH );
        buttons.setResultScreen(this);

        results = new BarChart(list);
        c.add(results, BorderLayout.CENTER);

        stats = new Statistics();
        c.add(stats, BorderLayout.NORTH);
        stats.setResultScreen(this);

        this.setBounds( 100, 100, 1000, 1000 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setVisible( true );
    }

    //public void getAlternativeElection()
    //{ return a;

    //}

    public void updateBarChart(ArrayList<Candidate> list) {
        results.setCandidateList(list);
        results.update();
    }
}
