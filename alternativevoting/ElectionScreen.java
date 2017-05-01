package alternativevoting;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class ElectionScreen extends JFrame
{
    public ElectionScreen()
    {
        super( "Vote now on your phones!" );
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        list.add( new Candidate( "Jeffrey", 12 ) );
        list.add( new Candidate( "Austin", 2 ) );
        list.add( new Candidate( "De Facto", 3 ) );
        list.add( new Candidate( "Matthew", 23 ) );
        BarChart chart = new BarChart( list );
        c.add( chart, BorderLayout.CENTER );
    }


    public static void main( String[] args )
    {
        ElectionScreen w = new ElectionScreen();
        w.setBounds( 100, 100, 700, 700 );
        w.setDefaultCloseOperation( EXIT_ON_CLOSE );
        w.setVisible( true );
    }
}
