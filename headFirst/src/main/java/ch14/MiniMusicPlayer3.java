package ch14;

//----- Page 502 Exercise -----

// Import Java MIDI API for sound generation
import javax.sound.midi.*;
// Import Swing components for GUI
import javax.swing.*;
// Import AWT for drawing and colors
import java.awt.*;
// Import for generating random numbers
import java.util.Random;
// Static import for MIDI command constants 
//(NOTE_ON, NOTE_OFF, CONTROL_CHANGE)
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayer3 { //outer class
// Panel where graphics will be drawn (inner class instance)
  private MyDrawPanel panel;
// Random number generator for notes and colors
  private Random random = new Random();

  public static void main(String[] args) {
// Create instance of the program and start it
    MiniMusicPlayer3 mini = new MiniMusicPlayer3();
    mini.go();
  }

// Sets up the GUI window and adds the drawing panel  
  public void setUpGui() {
    JFrame frame = new JFrame("My First Music Video"); // Window title
    panel = new MyDrawPanel(); // Create the panel
    frame.setContentPane(panel); // Put panel into frame
    frame.setBounds(30, 30, 300, 300); // Set position & size
    frame.setVisible(true); // Show the frame
  }

// Main logic to set up MIDI sequencer, track, and events
  public void go() {
    setUpGui(); // Build GUI first

    try {
// Get a sequencer (device that plays back MIDI sequences)
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open(); // Open it for use
      
// Register our panel to listen for MIDI controller events 
//(controller number 127)
      sequencer.addControllerEventListener(panel, new int[]{127});
      
// Create a new MIDI sequence with 4 ticks per quarter note
      Sequence seq = new Sequence(Sequence.PPQ, 4);
// Create a track to store MIDI events
      Track track = seq.createTrack();

      int note;
// Loop to create a sequence of notes
      for (int i = 0; i < 60; i += 4) { // Every 4 ticks
// Pick a random note between 1 and 50
        note = random.nextInt(50) + 1;
        
// Add a NOTE_ON event (start playing a note)        
        track.add(makeEvent(NOTE_ON, 1, note, 100, i));
        
 // Add a CONTROL_CHANGE event — our drawing panel will respond to this
        track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
        
// Add a NOTE_OFF event (stop the note) two ticks later
        track.add(makeEvent(NOTE_OFF, 1, note, 100, i + 2));
      }

// Load sequence into sequencer
      sequencer.setSequence(seq);
// Start playbac
      sequencer.start();
// Set tempo
      sequencer.setTempoInBPM(120);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
     * Utility method to create a MIDI event.
     * @param cmd MIDI command (NOTE_ON, NOTE_OFF, CONTROL_CHANGE)
     * @param chnl MIDI channel (usually 0 or 1)
     * @param one First data byte (note number or controller number)
     * @param two Second data byte (velocity or value)
     * @param tick When in the track this event should happen
     * @return A MIDI event ready to add to a track
     */
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

// Inner class responsible for drawing and responding to MIDI events
  class MyDrawPanel extends JPanel implements ControllerEventListener {

// Flag to indicate if a controller event has occurred   
    private boolean msg = false;

// Called when a registered MIDI controller event is received    
    @Override
    public void controlChange(ShortMessage event) {
      msg = true; // Set flag
      repaint(); // Trigger repaint to draw new graphics
    }

// Called by Swing when the panel needs to be redrawn
    @Override
    public void paintComponent(Graphics g) {
      if (msg) { // Only draw when an event has occurred
          
// Generate random color
        int r = random.nextInt(250);
        int gr = random.nextInt(250);
        int b = random.nextInt(250);

        g.setColor(new Color(r, gr, b));

// Generate random rectangle size and position
        int height = random.nextInt(120) + 10;
        int width = random.nextInt(120) + 10;

        int xPos = random.nextInt(40) + 10;
        int yPos = random.nextInt(40) + 10;

// Draw filled rectangle
        g.fillRect(xPos, yPos, width, height);
        
// Reset flag so it only draws once per event
        msg = false;
      }
    }
  }

}