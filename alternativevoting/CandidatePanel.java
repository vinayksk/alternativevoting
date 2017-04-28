package alternativevoting;

import java.util.*;
import javax.swing.*;


/**
 * One of these should be called each time an election goes on (for each
 * Position).
 *
 * @author alin908
 * @version Apr 28, 2017
 * @author Period: TODO
 * @author Assignment: alternativevoting
 *
 * @author Sources: TODO
 */
public class CandidatePanel extends JPanel
{
    private ArrayList<Candidate> candidates;

    private ArrayList<JButton> buttons;


    /**
     * Should be called after finding list of all candidates for a position
     * 
     * @param c
     */
    public CandidatePanel( ArrayList<Candidate> candidateList )
    {
        candidates = candidateList;
        buttons = new ArrayList<JButton>( candidateList.size() );
        for ( Candidate c : candidateList )
        {
            buttons.add( new JButton() )
        }
    }
}
