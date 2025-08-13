package ch13;

import javax.sound.midi.*;

public class MusicTest1 {
  public void play() {
    try {
//we get a sequencer object which is the main part of the MIDI device/instrument
//it sequences all the MIDI information(data on how a song should play),
//and sends it to the right instruments or plays the music i.e. playback device
      Sequencer sequencer = MidiSystem.getSequencer();
      System.out.println("Successfully got a sequencer");
    } catch(MidiUnavailableException e) {
      System.out.println("Bummer");
    }
  }

  public static void main(String[] args) {
    MusicTest1 mt = new MusicTest1();
    mt.play();
  }
}