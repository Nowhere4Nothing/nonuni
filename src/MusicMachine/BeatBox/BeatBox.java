package MusicMachine.BeatBox;
import MusicMachine.Extra.MiniMusicPlayer;
import MusicMachine.MyDrawPanel;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;

import static javax.sound.midi.ShortMessage.*;

public class BeatBox {
    private ArrayList<JCheckBox> checkboxList;
    //we store the checkboxes in an arraylist
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private MyDrawPanel panel;
    private Random random = new Random();

    private JLabel ps;

    String[] instrumentNames = {"Bass drum 35", "Acoustic Snare 38", "Hand Clap 39", "Closed Hi-Hat 42", "Open Hi-Hat 46", "Low-mid Tom 47",
            "Crash Cymbal 49", "High Tom 50", "Cowbell 56", "Vibraslap 58", "High Bongo 60", "Open Hi Conga 63 ", "Low Conga 64",
            "High Agogo 67", "Maracas 70", "Whistle 72" };
    int[] instruments = {35, 38, 39, 42, 46, 47, 49, 50, 56, 58, 60, 63, 64, 67, 70, 72};

    public static void main (String[]args) {
        new BeatBox().buildGUI();
    } // end main

    public void buildGUI() {
        JFrame frame = new JFrame("Cyber BeatBox");
        panel = new MyDrawPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel backGround = new JPanel(layout);


        backGround.setBorder(BorderFactory.createEtchedBorder(100, Color.black, Color.cyan));
        //an empty border gives us a margin between the edges of the panel

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> buildTrackAndStart());
        //calling a method to start the track
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> sequencer.stop());
        //calling a method to stop the track
        buttonBox.add(stop);

        JButton upTempo = new JButton("Up Tempo");
        upTempo.addActionListener(e -> changeTempo(1.03f));
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("DownTempo");
        downTempo.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(downTempo);
        //defult tempo is 1.0

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4,1,4,1));
            nameBox.add(instrumentLabel);

        } // end for list
            nameBox.add(buttonBox);
//        backGround.add(BorderLayout.CENTER,panel);
        backGround.add(BorderLayout.WEST, nameBox);


        frame.getContentPane().add(backGround);

        GridLayout grid = new GridLayout(16,16);
        //this one lets you put components in a grid with rows and columns
        grid.setVgap(1);
        grid.setHgap(2);


        JPanel mainPanel = new JPanel(grid);
        backGround.add(BorderLayout.CENTER,mainPanel);

        checkboxList = new ArrayList<>();
        for (int i = 0; i <256; i++) {
            JCheckBox checkBoxForloop = new JCheckBox();
            checkBoxForloop.setSelected(false);
            checkboxList.add(checkBoxForloop);
            mainPanel.add(checkBoxForloop);
            //Mak the checkboxes false and add them to the array and the GUI panel
        } // end for loop

        setUpMidi();

        backGround.add(BorderLayout.EAST,panel);

        frame.setSize(600,600);
        frame.pack();
        frame.setVisible(true);


            } // end method build gui

    public void setUpMidi() {
        try {
             sequencer = MidiSystem.getSequencer();
             sequencer.open();
            sequencer.addControllerEventListener(panel,new int[] {127});
             sequence = new Sequence(Sequence.PPQ, 4);
             track = sequence.createTrack();
             sequencer.setTempoInBPM(120);
        } // end try
        catch (Exception e){
            e.printStackTrace();
        } // end catch
    } // end method setupmidi

    private void buildTrackAndStart() {
        int[] tracklist;
        /* make a 1b-element array to hod the valu for one instrument, across all beats
        If instrument is supposed to play pn that beat, the value of it will be the key.
        If the instrument does not play on the beat, then put in a 0.
        */

        sequence.deleteTrack(track);
        track = sequence.createTrack();
        //get rid of old track and make a new one

        for (int i = 0; i <16; i++) {
            // do this for all 16 instruments (ROWS)
            tracklist = new int[16];

            int key = instruments[i];
            /*
            Set the key that represents which instruments this is (bass, hihat etc)
            the instrument array holds the MIDI numbers for that instrument
             */

            for (int j = 0; j < 16; j++) {
                //this is done for the beats in each row
                JCheckBox jc = checkboxList.get(j + 16 * i);
                if (jc.isSelected()) {
                    tracklist[j] = key;
                } // end if loop
                else {
                    tracklist[j] = 0;
                    /*
                    Is the checkbox at the beat selected? If yes.
                    Put the key value in theis slot in the array
                    Otherwise, the instrument is not supposed to play at this beat, set to 0
                     */
                } // end else
            } // end inner for loop

            makeTracks(tracklist);
            // For this instrument and for all 16 beats, make events and add them to the track
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16));
        } // end outer for loop

        track.add(makeEvent(PROGRAM_CHANGE, 9 , 1, 0, 15));
        /* we want to make sure that there is an event at beat 16
        Otherwise, beatbox might not go the full 16 beats before it starts over
        */

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            //specify the number of loops iterations, or forever looping
            sequencer.setTempoInBPM(120);
            sequencer.start();
            // plays it
        } // end try
        catch (Exception e) {
            e.printStackTrace();
        } // end catch
    } // end method buikdtrackandstart

    private void changeTempo(float tempoMultiplier) {
    float tempoFactor = sequencer.getTempoFactor();
    sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    /*
    Tempofactor scales the sequencers tempo by the factor provided,
    slowing the beat down or speeding it up
     */
    } // end method changetempo

    private void makeTracks(int[] list) {
        for (int i = 0; i <16; i++) {
            int key = list[i];

            if (key !=0) {
                track.add(makeEvent(NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(NOTE_OFF, 9, key, 100, i +1));
                //Make note on and off, then add them to the track
            } // end if statement
        } // end for loop
        /*
        this makes events for one instrument at a time, for all the beats
        so it might get an in[] for the bass drum, and each index of the array
        will hold either they key to the instrument or a zero.
        if it is a 0, the instrument is not supposed to play at taht beat.
        Otherwise make an event and add it to the track
         */
    }// end method maketracks

    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick ) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd,chnl,one,two);
            event = new MidiEvent(msg, tick);
        } // end try
        catch (Exception e) {
            e.printStackTrace();
        } // end catch
        return event;
    } // end method make Event

    class MyDrawPanel extends JPanel implements ControllerEventListener
    {
       private boolean msg = false;
        //set flag to false and then to treu when we got an  event

        public void controlChange (ShortMessage event) {
            msg = true;
            //got an event so set to true
            repaint();
        } // end method control changhe

        public void paintComponent (Graphics g) {
//            Image image = new ImageIcon(getClass().getResource("Roo.jpg")).getImage();
//            g.drawImage(image,3,4,this);
            //putting in an image x + y = top left corner (where it will be)

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
} // end class beatbox
