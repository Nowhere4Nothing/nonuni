package RandoGUITricks;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

    public class MyDrawPanel extends JPanel {

        public void paintComponent (Graphics g) {
//        g.setColor(Color.RED);
//        g.fillRect(20,50,100,100);
            // setting a color

//            Image image = new ImageIcon(getClass().getResource("Roo.jpg")).getImage();
//            g.drawImage(image,3,4,this);
            //putting in an image x + y = top left corner (where it will be)

            g.fillRect(0,0, this.getWidth(),this.getHeight());
            //fill the background. fillRect is the default color black

            Graphics2D g2D = (Graphics2D) g;
            Random random = new Random();
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color startColor = new Color(red,green,blue);

            red = random.nextInt(256);
            green = random.nextInt(256);
            blue = random.nextInt(256);
            Color endColor = new Color(red,green,blue);

            GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);
            g2D.setPaint(gradient);
            g2D.fillOval(70,70,100,100);

        } // end paintComponent
    } // end class

