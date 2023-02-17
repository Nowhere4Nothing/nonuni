package MusicMachine;
import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMinimusicApp {
    public static void main (String [] args) {
        MiniMinimusicApp mini = new MiniMinimusicApp();
        mini.play();
    } // end main method

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage msg = new ShortMessage();
            msg.setMessage(192, 1, 102,0);
            MidiEvent instrument = new MidiEvent(msg,1);
            track.add(instrument);

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 1, 70,100);
            MidiEvent noteOn = new MidiEvent(msg1,1);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();

            msg2.setMessage(NOTE_OFF, 1, 70,100);
            MidiEvent noteOff = new MidiEvent(msg2, 6);
            track.add(noteOff);

            ShortMessage msg3 = new ShortMessage();
            msg3.setMessage(NOTE_ON, 1, 90, 100);
            MidiEvent noteOn2 = new MidiEvent(msg3,6);
            track.add(noteOn2);

            ShortMessage msg4 = new ShortMessage();
            msg4.setMessage(NOTE_OFF, 1, 90, 100);
            MidiEvent noteOff2 = new MidiEvent(msg4, 10);
            track.add(noteOff2);

            ShortMessage msg5 = new ShortMessage();
            msg5.setMessage(NOTE_ON, 1, 60, 100);
            MidiEvent noteOn3 = new MidiEvent(msg3,11);
            track.add(noteOn3);

            ShortMessage msg6 = new ShortMessage();
            msg6.setMessage(NOTE_OFF, 1, 60, 100);
            MidiEvent noteOff3 = new MidiEvent(msg4, 15);
            track.add(noteOff3);


            player.setSequence(seq);

            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        } // end catch
    } // end method play
} // end class miniminimusicapp
