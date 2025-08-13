package ch11;

class SongV2 {
//Declare three instance variables for three song attributes in file    
  private String title;
  private String artist;
  private int bpm;

//Constructor sets all three instance variables when,
//a new Song object is instantiated
  SongV2(String title, String artist, int bpm) {
    this.title = title;
    this.artist = artist;
    this.bpm = bpm;
  }
  
//Getter  methods for the three attributes
  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public int getBpm() {
    return bpm;
  }

//Overriding Object class's 'toString()' method to return the title  
  @Override
  public String toString() {
    return title;
  }
}
