package alternativevoting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


/**
 * The FinalActionButtons class allows certain actions to be performed on a
 * ResultScreen.
 *
 * @author Andrew Lin
 * @version May 29, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 *
 * @author Sources: None
 */
public class FinalActionButtons extends JPanel implements ActionListener
{
    private JButton eliminateButton;

    private JButton doneButton;

    private ResultScreen r;


    /**
     * Creates buttons for GUI for various purposes
     */
    public FinalActionButtons()
    {
        eliminateButton = new JButton( "Eliminate a Candidate" );
        eliminateButton.setPreferredSize( new Dimension( 300, 100 ) );
        eliminateButton.addActionListener( this );
        add( eliminateButton );
        eliminateButton.setFont( new Font( "Helvetica", Font.PLAIN, 20 ) );

        doneButton = new JButton( "Get Statistics" );
        doneButton.setPreferredSize( new Dimension( 300, 100 ) );
        doneButton.addActionListener( this );
        add( doneButton );
        doneButton.setFont( new Font( "Helvetica", Font.PLAIN, 20 ) );
    }


    /**
     * Sets a reference to the parent result scren.
     * 
     * @param r
     *            The parent result screen
     */
    public void setResultScreen( ResultScreen r )
    {
        this.r = r;
    }


    /**
     * Performs an action. If the action was to eliminate a candidate, a
     * candidate is eliminated using AlternativeElection and the barchart is
     * redrawn. Otherwise, a pop-up window appears with statistics.
     * 
     * @param e
     *            The action event
     */
    public void actionPerformed( ActionEvent e )
    {
        JButton button = (JButton)e.getSource();
        if ( button.getText().equals( "Eliminate a Candidate" ) )
        {
            r.updateBarChart( r.getAlternativeElection().eliminateCandidate() );
        }
        else
        {
            // JPanel panel = new JPanel();
            JFrame frame = new JFrame( "Election statistics" );
            int[][] data = BallotStats.prefTable(
                r.getAlternativeElection().getBallots(),
                r.getAlternativeElection().getCandList() );
            double[][] data2 = BallotStats.prefTablePerc(
                r.getAlternativeElection().getBallots(),
                r.getAlternativeElection().getCandList() );
            // headers for the table
            JTable table = new JTable( data.length * 2 + 2, data.length + 1 );
            table.setRowHeight( 50 );
            for ( int i = 0; i < data.length + 1; i++ )
            {
                table.getColumnModel().getColumn( i ).setPreferredWidth( 50 );
            }
            for ( int i = 0; i < data.length; i++ )
            {
                for ( int j = 0; j < data.length; j++ )
                {
                    table.setValueAt( data[i][j], i + 1, j + 1 );
                    table.setValueAt( data2[i][j], i + data.length + 2, j + 1 );
                }
            }

            for ( int i = 0; i < data.length; i++ )
            {
                table.setValueAt(
                    r.getAlternativeElection().getCandList().get( i ).getName(),
                    0,
                    i + 1 );
                table.setValueAt(
                    r.getAlternativeElection().getCandList().get( i ).getName(),
                    data.length + 1,
                    i + 1 );
                table.setValueAt(
                    r.getAlternativeElection().getCandList().get( i ).getName(),
                    i + 1,
                    0 );
                table.setValueAt(
                    r.getAlternativeElection().getCandList().get( i ).getName(),
                    i + data.length + 2,
                    0 );
                table.setValueAt( "X", i + 1, i + 1 );
                table.setValueAt( "X", data.length + i + 2, i + 1 );
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
