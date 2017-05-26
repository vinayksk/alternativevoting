package alternativevoting;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.applet.*;

/**
 * Created by Andrew on 5/19/2017.
 */
public class VoterApplet extends Applet
{
    public void init()
    {
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        list.add(new Candidate("Jeffrey", 3));
        list.add(new Candidate("Vinay", 4));
        ElectionScreen e = new ElectionScreen(list, "bad");
        e.setVisible(true);
        this.add(e);
        this.setVisible(true);
    }
}


