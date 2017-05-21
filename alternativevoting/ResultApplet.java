package alternativevoting;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Andrew on 5/21/2017.
 */
public class ResultApplet extends JApplet
{
    public void init()
    {
        ResultScreen r = new ResultScreen("hmm", new BallotStats());
        this.add(r);
    }
}