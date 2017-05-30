//package alternativevoting;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//
//import static javax.swing.JFrame.EXIT_ON_CLOSE;
//
///**
// * Created by Andrew on 5/25/2017.
// */
//public class Statistics extends JPanel implements ActionListener
//{
//    private JButton statButton, explainButton;
//    ResultScreen r;
//
//    public Statistics()
//    {
//        statButton = new JButton( "Get Statistics" );
//        statButton.setPreferredSize( new Dimension( 200, 100 ) );
//        statButton.addActionListener( this );
//        add(statButton);
//
//        explainButton = new JButton( "Explanation" );
//        explainButton.setPreferredSize( new Dimension( 200, 100 ) );
//        explainButton.addActionListener( this );
//        add( explainButton );
//    }
//
//    public void setResultScreen(ResultScreen r)
//    {
//        this.r = r;
//    }
//
//    public void actionPerformed(ActionEvent e)
//    {
//        JButton button = (JButton)e.getSource();
//        if ( button.getText().equals( "Get Statistics" ) )
//        {
//            JFrame frame = new JFrame();
//            JLabel text = new JLabel("text");
//            JPanel panel = new JPanel();
////            double[][] pref = BallotStats.pollProbabilities(r.getAlternativeElection().getBallots(), r.getAlternativeElection().getCandList());
////            String str = "";
////            for(int i=0;i<pref.length;i++)
////            {
////                for(int j=0;j<pref[0].length;j++)
////                {
////                    str += pref[i][j] + " ";
////                }
////                str += "\n";
////            }
//           // text.setText(str);
//            text.setText("asdfk;lashfldahfklhdslfshflashlfdshlasdhfkladsh");
//            panel.add(text);
//            frame.add(panel, BorderLayout.CENTER);
//            frame.setBounds( 100, 100, 200, 200 );
//            frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
//            frame.setVisible(true);
//        }
//        else if(button.getText().equals("Explanation"))
//        {
//            System.out.println("Ask Vinay");
//        }
//    }
//}
