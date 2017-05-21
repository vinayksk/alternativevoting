package alternativevoting;

import javax.swing.*;


public class BallotStats extends JPanel
{
    JLabel display;
    // fields that store data


    public BallotStats()
    {
        display = new JLabel();
        display.setText("Default");
        this.add(display);
    }


    public void addData( // something here?
    )
    {
        // idk what we do here
        update();
    }


    public void update()
    {
        display.setText( "New stuff" );
    }
}
