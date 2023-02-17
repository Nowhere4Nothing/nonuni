package RandoGUITricks;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea {
    public static void main (String[]args) {
        TextArea gui = new TextArea();
        gui.go();
    } // end main

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        JButton button = new JButton("Click me");



        JTextArea text = new JTextArea(10,20);
        text.setText("A coffee a day keeps the doctor away \n");
        text.setLineWrap(true);
        button.addActionListener(e -> text.append("Button Clicked! \n"));
        //using a lambda to impliement the actionlistner
        // insertin a new line to go on a seperate line everytime the button is clicked

        JCheckBox check = new JCheckBox("Turn to 11");
        String onOrOff = "off";
        if (check.isSelected()) {
            onOrOff = "on";

        } // end if
        System.out.println("Check is: " + onOrOff);
        check.addActionListener(e -> text.append("CheckBox Clicked! \n"));

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //setting the text area to only scroll down

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.WEST,check);

        frame.setSize(350,300);
        frame.setVisible(true);

    } // end method go





} // end class text
