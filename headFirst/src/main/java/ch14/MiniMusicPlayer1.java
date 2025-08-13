package ch14;

import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayer1 {
    
  public static void main(String[] args) {
    try {
//Make and open a sequencer        
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();

// Make a sequence and a track     
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

//Make events that make the notes keep going up from piano note 5 - 61      
      for (int i = 5; i < 61; i += 4) {         
//Using makeEvent utility method to make message and event then add to track
//result added to track is MidiEvent returned from makeEvent()
        track.add(makeEvent(NOTE_ON, 1, i, 100, i));
        track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));
      }

//Start running      
      sequencer.setSequence(seq);
      sequencer.setTempoInBPM(220);
      sequencer.start();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

//Utility method that makes a message and returns a MidiEvent    
//'tick' arg is for when the message should happen  
  public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage msg = new ShortMessage();
      msg.setMessage(cmd, chnl, one, two);
      event = new MidiEvent(msg, tick);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return event;
  }
}