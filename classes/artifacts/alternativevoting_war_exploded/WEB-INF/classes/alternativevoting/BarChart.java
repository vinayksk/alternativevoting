package alternativevoting;

import java.util.*;
import java.awt.*;
import javax.swing.*;


public class BarChart extends JPanel
{
    ArrayList<Candidate> candList;

    int totalVotes;

    ArrayList<Color> candColors;


    public BarChart( ArrayList<Candidate> list )
    {
        setBackground( Color.WHITE );
        candList = list;
        for ( int i = 0; i < candList.size(); i++ )
        {
            totalVotes += candList.get( i ).getVotes();
        }
        candColors = new ArrayList<Color>();
        for ( int i = 0; i < candList.size(); i++ )
        {
            candColors.add(
                new Color( (int)( 120 + 63.0 * ( i + 1 ) / candList.size() ),
                    (int)( 120 + 34.0 * ( i + 1 ) / candList.size() ),
                    (int)( 120 + 23.0 * ( i + 1 ) / candList.size() ) ) );
        }
    }


    public ArrayList<Candidate> getCandidateList()
    {
        return candList;
    }


    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        int barWidth = getHeight() / candList.size() / 3;
        int maxBarHeight = getWidth() * 3 / 4;
        if ( totalVotes > 0 )
        {
            for ( int i = 0; i < candList.size(); i++ )
            {
                g.setColor( candColors.get( i ) );
                g.fillRect( getWidth() / 4,
                    (int)( getHeight() / 8 + i * barWidth * 1.5 ),
                    (int)( maxBarHeight * candList.get( i ).getVotes() * 1.0
                        / totalVotes ),
                    barWidth );
                g.setColor( Color.BLACK );
                g.drawString(
                    Integer.toString(
                        candList.get( i ).getVotes() * 100 / totalVotes ) + "%",
                    getWidth() / 4,
                    (int)( getHeight() / 8 + i * barWidth * 1.5 ) );
                g.drawString( candList.get( i ).getName(),
                    getWidth() / 8,
                    (int)( 3 * getHeight() / 16 + i * barWidth * 1.5 ) );
            }
        }
    }


    public void update()
    {
        paintComponent( this.getGraphics() );
    }
}
