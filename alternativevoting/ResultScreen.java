package alternativevoting;

import java.awt.Container;

import javax.swing.JFrame;


public class ResultScreen extends JFrame
{
    BarChart results;


    public ResultScreen( String electionName )
    {
        super( electionName );
        Container c = getContentPane();
    }
}
