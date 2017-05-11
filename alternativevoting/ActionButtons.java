package alternativevoting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class ActionButtons extends JPanel implements ActionListener
{
    private JButton clearButton, submitButton, tutorial;

    private VisualBallot b;

    private VoterInfo v;

    // Account details for Azure database
    private String hostName = "warowac";

    private String dbName = "testDB";

    private String user = "warowac";

    private String password = "XoFruitL00ps";

    private String url = String.format(
        "jdbc:sqlserver://%s.database.windows.net:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
        hostName,
        dbName,
        user,
        password );

    private Connection connection = null;


    public ActionButtons( VisualBallot b, VoterInfo v )
    {
        clearButton = new JButton( "Clear" );
        clearButton.setPreferredSize( new Dimension( 90, 80 ) );
        clearButton.addActionListener( this );
        add( clearButton );

        submitButton = new JButton( "Vote" );
        submitButton.setPreferredSize( new Dimension( 80, 80 ) );
        submitButton.addActionListener( this );
        add( submitButton );

        tutorial = new JButton( "Tutorial" );
        tutorial.setPreferredSize( new Dimension( 90, 80 ) );
        tutorial.addActionListener( this );
        add( tutorial );

        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );

        this.b = b;

        this.v = v;
    }


    public VisualBallot getBallot()
    {
        return b;
    }


    public void actionPerformed( ActionEvent e )
    {
        try
        {
            connection = DriverManager.getConnection( url );
            Statement mystat = connection.createStatement();

            JButton button = (JButton)e.getSource();
            if ( button.getText().equals( "Clear" ) )
            {
                b.clearBallot();
            }
            else if ( button.getText().equals( "Vote" ) )
            {
                int[] array = b.pushBallot();
                String str = v.getVoterName();
                String electionName = ( (ElectionScreen)( SwingUtilities
                    .getWindowAncestor( this ) ) ).getElectionName();
                ArrayList<Candidate> candidates = ( (ElectionScreen)( SwingUtilities
                    .getWindowAncestor( this ) ) ).getCandidates();
                // here is where you put it into database (array & str)
                String newvoter = "insert into " + electionName + " (name";

                for ( int i = 0; i < candidates.size(); i++ )
                {
                    newvoter = newvoter + ", " + candidates.get( i );
                }
                newvoter = newvoter + ") values (\'" + str + "\'";
                for ( int i = 0; i < array.length; i++ )
                {
                    newvoter = newvoter + ", " + array[i];
                }
                newvoter = newvoter + ")";
                System.out.println( newvoter );

                mystat.executeUpdate( newvoter );
                System.out.println( "added the next voter" );
                b.clearBallot();
            }
            else if ( button.getText().equals( "Tutorial" ) )
            {
                System.out.println(
                    "Rank your candidates from 1 to N, where N is your least preferred candidate! If you don't want to vote for a candidate, just leave it blank." );
            }
        }

        catch ( Exception exc )
        {
            exc.printStackTrace();
        }

    }
}