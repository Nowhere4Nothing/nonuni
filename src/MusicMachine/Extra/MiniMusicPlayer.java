package MusicMachine.Extra;
import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayer {
    private MyDrawPanel2 panel;
    private Random random = new Random();

    public static void main (String[]args) {
        MiniMusicPlayer mini = new MiniMusicPlayer();
        mini.go();
    } // end main

    public void SetUpGui() {
        JFrame frame = new JFrame("My first music video");
        panel = new MyDrawPanel2();
        frame.setContentPane(panel);
        frame.setBounds(30,30,300,300);
        frame.setVisible(true);
    } // end method setupgui

    public void go() {
        SetUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(panel,new int[] {127});
            //making the event for the paint
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            int note;
            for (int i = 0; i <60; i+=4) {
                //make a bunch of events to keep the notes going up (piano note 5 to 61)
                note = random.nextInt(50) + 1;
                track.add(makeEvent(NOTE_ON,1,note,100,i));
                track.add(makeEvent(CONTROL_CHANGE,1,127,0,i));
                // this is the event that we use to create an event for the paint
                track.add(makeEvent(NOTE_OFF,1,note,100,i +2));
                //call our new makeEvent() to make the message and event, then add the result.
            } // end of for loop

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);
            //start it running
        } // end of try
        catch (Exception ex) {
            ex.printStackTrace();
        } // end of catch
    } // end of method go

    public static MidiEvent makeEvent (int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd,chnl,one,two);
            event = new MidiEvent(msg, tick);
            //make the messsage and the event using the above parameters
        } // end try
        catch (Exception e) {
            e.printStackTrace();
        } // end catch
        return event;
    } // end method makeevent

    class MyDrawPanel2 extends JPanel implements ControllerEventListener {
        private boolean msg = false;
        //set flag to false and then to treu when we got an  event

        public void controlChange (ShortMessage event) {
            msg = true;
            //got an event so set to true
            repaint();
        } // end method control changhe

        public void paintComponent (Graphics g) {
            if (msg) {
                //we have to use a flag becase other things might triger a repaint, only want repaint when there is an event
                int r = random.nextInt(250);
                int gr = random.nextInt(250);
                int b = random.nextInt(250);

                g.setColor(new Color(r,gr,b));

                int height = random.nextInt(120) + 10;
                int width = random.nextInt(120) + 10;

                int xpos = random.nextInt(40) + 10;
                int ypos = random.nextInt(40) +10;

                g.fillRect(xpos,ypos,width,height);
                //code to generate a random colour and paint a semirandom triangle
                msg = false;
            } // end if
        } // end class paintcomponent
    } // end class mydrawpanel

} // end class minimusicplayer
