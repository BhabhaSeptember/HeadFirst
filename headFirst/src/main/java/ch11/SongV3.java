package ch11;

//Specifying the type that the implementing class can be compared against
class SongV3 implements Comparable<SongV3> {
  private String title;
  private String artist;
  private int bpm;

//compareTo() method returns negative number, zero or positive number:
//neg number: Object running the method < object passed into method parameter
//zero: Objects are equal (not the same object)
//pos number: Object running the method > object passed into method parameter   

  
//implementing the Comparable interface's method  
  @Override  
  public int compareTo(SongV3 s) { 
    return title.compareTo(s.getTitle());
  }

  SongV3(String title, String artist, int bpm) {
    this.title = title;
    this.artist = artist;
    this.bpm = bpm;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public int getBpm() {
    return bpm;
  }

  @Override
  public String toString() {
    return title;
  }
}
