package MusicMachine;
import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {

    public void paintComponent (Graphics g) {
//        g.setColor(Color.BLUE);
//        g.fillRect(20,50,100,100);

        Image image = new ImageIcon(getClass().getResource("Roo.jpg")).getImage();
        g.drawImage(image,3,4,this);

    } // end paintComponent
} // end class
