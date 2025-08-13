package ch13;

//Import the midi package
import javax.sound.midi.*;
//Static import for access to constants in ShortMessage class
import static javax.sound.midi.ShortMessage.*;

public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
//Get a sequencer and open it        
            Sequencer player = MidiSystem.getSequencer();
            player.open();

//Create a Sequence object using a 2-arg constructor      
            Sequence seq = new Sequence(Sequence.PPQ, 4);

//Ask Sequence for a Track. 
//A Track lives in the Sequence and MIDI data livesin Track      
            Track track = seq.createTrack();

//Put some MIDI events into Track      
//MIDI instruction goes into a Message object
            ShortMessage msg1 = new ShortMessage();
            
//Message says 'start playing note 44'  
//setMessage(messageType, channel, noteToPlay, velocity)
//1)messageType 144/ShortMessage.NOTE_ON=noteOn, 128/ShortMessage.NOTE_OFF=noteOff
//2)channel is like musician in band e.g. channel 1 = musician 1(drummer)
//3)noteToPlay is number from 0 to 127 going from low to high notes
//4)velocity refers to how fast/hard key is pressed 0=tooSoft, 100=good default
            msg1.setMessage(144, 1, 20, 100);
            
//192 means change instrument message in specified channel (here it's channel 1)
//And change it to instrument 102
//            ShortMessage first = new ShortMessage();
//            first.setMessage(192, 1, 102, 0);
            
//noteOn even declares the moment to START playing a note  
//MidiEvent is combination of message and moment in time when it should fire or
//at which beat it should happen i.e. at first beat
            
            MidiEvent noteOn = new MidiEvent(msg1, 1);
//Track holds all MidiEvent objects. Sequence organizes them according to
//when each event if supposed to happen
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(128, 1, 44, 100);
//noteOff event declares the moment to STOP playing a note      
            MidiEvent noteOff = new MidiEvent(msg2, 3);
            track.add(noteOff);

//Give the Sequence to the Sequencer (like selecting song to play)      
            player.setSequence(seq);
//Start the Sequencer (play the song)      
            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
