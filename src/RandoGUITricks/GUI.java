package RandoGUITricks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class GUI  {
        private JFrame frame;
        private JLabel label;

        public static void main (String [] args) {
            GUI gui = new GUI();
            gui.go();
        } // end main method

        public void go() {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton labelButton = new JButton("Change label");
            labelButton.addActionListener(event -> label.setText("Weeee"));
            //add the listener (this) for the label

            JButton colorButton = new JButton("Change Circle colour");
            colorButton.addActionListener(event -> frame.repaint());
            //add the listener for the button

            label = new JLabel("Im a label");
            MyDrawPanel drawPanel = new MyDrawPanel();

            frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
            frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
            frame.getContentPane().add(BorderLayout.WEST, label);
            frame.getContentPane().add(BorderLayout.EAST, labelButton);
            //add the 2 widgets (button and drawing panel) to the regions of the frame

            frame.setSize(300, 300);
            frame.setVisible(true);
            //make it visable

        } // end method go

//        public class LabelListener implements ActionListener {
//            public void actionPerformed(ActionEvent event) {
//                label.setText("Weee");
//                // when the user clicks it tells the label to change text.
//            } // end method action
//        } // end class colour
//
//        public class colorListener implements ActionListener {
//            public void actionPerformed(ActionEvent event) {
//                frame.repaint();
                // when the user clicks it tells the frame to repaint itself. it calls paintComponate() on ever widget
//            } // end method action
//        } // end class colour
    } // end class Gui


