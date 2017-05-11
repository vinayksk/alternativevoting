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
    private JButton clearButton, submitButton;

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
        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );

        clearButton = new JButton( "Clear" );
        clearButton.setPreferredSize( new Dimension( 80, 40 ) );
        clearButton.addActionListener( this );
        add( clearButton );

        submitButton = new JButton( "Vote" );
        submitButton.setPreferredSize( new Dimension( 80, 40 ) );
        submitButton.addActionListener( this );
        add( submitButton );

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
        }

        catch ( Exception exc )
        {
            exc.printStackTrace();
        }

    }
}
