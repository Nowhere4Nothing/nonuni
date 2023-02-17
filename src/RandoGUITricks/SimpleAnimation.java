package RandoGUITricks;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit.*;

public class SimpleAnimation {
    private int xpos = 10;
    private int ypos = 10;

    public static void main (String [] args) {
        SimpleAnimation ani = new SimpleAnimation();
        ani.go();
    } // end main method

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        for (int i =0; i<150; i++) {
            xpos++;
            ypos++;

            drawPanel.repaint();

            try {
                TimeUnit.MILLISECONDS.sleep(60);
                //paus between repaints
            }// end try
            catch (Exception e) {
                e.printStackTrace();
            }// end catch
        } // end for loop
    } // end method go

    class MyDrawPanel extends JPanel {
        public void paintComponent (Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,getWidth(),getHeight());
            //stop the smear

            g.setColor(Color.GREEN);
            g.fillOval(xpos,ypos,40,40);
        } // end method paint
    }// end class mydrawpanel
} // end class SimpleAnimatiuon

