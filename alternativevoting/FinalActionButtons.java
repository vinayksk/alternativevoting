package alternativevoting;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


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

        doneButton = new JButton( "Get Statistics" );
        doneButton.setPreferredSize( new Dimension( 200, 100 ) );
        doneButton.addActionListener( this );
        add( doneButton );
    }


    public void setResultScreen( ResultScreen r )
    {
        this.r = r;
    }


    public void actionPerformed( ActionEvent e )
    {
        JButton button = (JButton)e.getSource();
        if ( button.getText().equals( "Eliminate a Candidate" ) )
        {
            r.updateBarChart( r.getAlternativeElection().eliminateCandidate() );
        }
        else
        {
            System.out.println( " cringe" );
            // JPanel panel = new JPanel();
            JFrame frame = new JFrame( "Election statistics" );
            int[][] data = BallotStats.prefTable(
                r.getAlternativeElection().getBallots(),
                r.getAlternativeElection().getCandList() );
            double[][] data2 = BallotStats.prefTablePerc(
                r.getAlternativeElection().getBallots(),
                r.getAlternativeElection().getCandList() );
            // headers for the table
            JTable table = new JTable( data.length * 2 + 1, data.length );
            for ( int i = 0; i < data.length; i++ )
            {
                for ( int j = 0; j < data.length; j++ )
                {
                    table.setValueAt( data[i][j], i, j );
                    table.setValueAt( data2[i][j], i + data.length + 1, j );
                }
            }

            // add the table to the frame
            frame.add( new JScrollPane( table ) );

            frame.setTitle( "Table Example" );
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.pack();
            frame.setVisible( true );
        }
    }
}
