package alternativevoting;

import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * Provides a way to draw a bar chart for candidates.
 *
 * @author Andrew Lin
 * @version May 16, 2017
 * @author Period: 3
 * @author Assignment: alternativevoting
 *
 * @author Sources: None
 */
public class BarChart extends JPanel
{
    private ArrayList<Candidate> candList;

    private int totalVotes;

    private ArrayList<Color> candColors;


    /**
     * Creates a new bar chart object. Assigns a color to each candidate.
     * @param list candidate list
     */
    public BarChart( ArrayList<Candidate> list )
    {
        setBackground( Color.WHITE );
        candList = list;
        if(list != null && list.size() > 0) {
            for (int i = 0; i < candList.size(); i++) {
                totalVotes += candList.get(i).getVotes();
            }
            candColors = new ArrayList<Color>();
            for (int i = 0; i < candList.size(); i++) {
                candColors.add(
                        new Color((int) (240 - 67.0 * (i + 1) / candList.size()),
                                (int) (67 + 34.0 * (i + 1) / candList.size()),
                                120));
            }
        }
    }

    /**
     * gets candidate list.
     * @return candidate list in an arraylist
     */
    public ArrayList<Candidate> getCandidateList()
    {
        return candList;
    }

    /**
     * sets the candidate list to list. Also changes total nuber of votes.
     * @param list the candidate list to be set
     */
    public void setCandidateList(ArrayList<Candidate> list)
    {
        candList = list;
        totalVotes = 0;
        for (int i = 0; i < candList.size(); i++) {
            totalVotes += candList.get(i).getVotes();
        }
    }

    /**
     * Draws a bar chart
     * @param g graphics
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        int barWidth = (int)((double)getHeight() / candList.size() / 2.5);
        int maxBarHeight = getWidth() * 3 / 4;
        g.setFont(new Font("Helvetica", Font.PLAIN, barWidth/2));
        if ( totalVotes > 0 )
        {
            for ( int i = 0; i < candList.size(); i++ )
            {
                g.setColor( candColors.get( i ) );
                g.fillRect( getWidth() / 8,
                    (int)( getHeight() / 4 + i * barWidth * 1.5 ),
                    (int)( maxBarHeight * candList.get( i ).getVotes() * 1.0
                        / totalVotes ),
                    barWidth );
                g.setColor( Color.BLACK );
                g.drawString(
                    Integer.toString((int)(candList.get( i ).getVotes() * 100.0 / totalVotes + 0.5) ) + "%",
                    getWidth() / 8,
                    (int)( getHeight() / 4 + i * barWidth * 1.5 ) );
                g.drawString( candList.get( i ).getName(),
                    getWidth() / 8,
                    (int)( getHeight() / 4 + i * barWidth * 1.5 + barWidth * 0.5) );
            }
        }
        else
        {
            for ( int i = 0; i < candList.size(); i++ )
            {
                g.setColor( candColors.get( i ) );
                g.fillRect( getWidth() / 4,
                    (int)( getHeight() / 8 + i * barWidth * 1.5 ),
                    1,
                    barWidth );
                g.setColor( Color.BLACK );
                g.drawString( "0%",
                    getWidth() / 4,
                    (int)( getHeight() / 8 + i * barWidth * 1.5 ) );
                g.drawString( candList.get( i ).getName(),
                    getWidth() / 8,
                    (int)( 3 * getHeight() / 16 + i * barWidth * 1.5 ) );
            }
        }
    }

    /**
     * updates the bar chart's graphics.
     */
    public void update()
    {
        paintComponent( this.getGraphics() );
    }
}
