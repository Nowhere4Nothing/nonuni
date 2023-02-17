package MusicMachine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGuil implements ActionListener {
    private JButton button;

    public static void main (String [] args) {
        SimpleGuil gui = new SimpleGuil();
        gui.go();
    } // end main method

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Click me");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        //make it visable

    } // end method go

    @Override
    public void actionPerformed(ActionEvent event) {
        button.setText("I have been clicked");
    }
} // end class SimpleGui
