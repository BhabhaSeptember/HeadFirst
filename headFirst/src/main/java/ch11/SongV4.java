package ch11;

//OVERRIDING HASHCODE() AND EQUALS() METHOD

class SongV4 implements Comparable<SongV4> {
  private String title;
  private String artist;
  private int bpm;

  @Override
  public boolean equals(Object aSong) {
    SongV4 other = (SongV4) aSong;
//Using String class overridden 'equals()' method to check if one title,
//is equal to the other song's title
    return title.equals(other.getTitle());
  }

  @Override
//String class has overridden hashCode() method so we can just return the, 
//result of calling hashCode() on title
  public int hashCode() {
    return title.hashCode();
  }

  @Override
  public int compareTo(SongV4 s) {
    return title.compareTo(s.getTitle());
  }

  
  SongV4(String title, String artist, int bpm) {
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
