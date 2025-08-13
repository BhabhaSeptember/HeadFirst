package ch10;

//Regular non-static methods example

public class Song {
//instance variable value affects the behaviour of the play() method below    
  String title;

  public Song(String t) {
    title = t;
  }

  public void play() {
    SoundPlayer player = new SoundPlayer();
//We require the current state of the 'title' instance variable, 
//in order to playSound...
    player.playSound(title);
  }
}

class SoundPlayer {
  public void playSound(String title) {

  }
}
