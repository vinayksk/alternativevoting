package alternativevoting;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;


public class VisualBallot extends JPanel
{
    ArrayList<Candidate> candList;
    
    public VisualBallot( ArrayList<Candidate> list )
    {
        setBackground( Color.WHITE );
    }
}
