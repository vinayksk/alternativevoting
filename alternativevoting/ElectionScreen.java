package alternativevoting;

import java.awt.*;
import javax.swing.*;


public class ElectionScreen extends JFrame
{
    public ElectionScreen()
    {
        super( "Vote now on your phones!" );
        
    }


    public static void main( String[] args )
    {
        ElectionScreen w = new ElectionScreen();
        w.setBounds( 300, 300, 400, 400 );
        w.setDefaultCloseOperation( EXIT_ON_CLOSE );
        w.setVisible( true );
    }
}
