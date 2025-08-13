package ch11;

import java.util.*;

public class Jukebox4 {
  public static void main(String[] args) {
    new Jukebox4().go();
  }

  public void go() {
    List<SongV3> songList = MockSongs.getSongsV3();
    System.out.println(songList);
    
//Sorting by title using compareTo() method
    Collections.sort(songList);
    System.out.println(songList);

//Make instance of Comparator class    
    ArtistCompare artistCompare = new ArtistCompare();
//Invoke sort() method on list, passing it a reference to new custom,
//Comparator object. Sorts using compare() method
    songList.sort(artistCompare);
    System.out.println(songList);
  }
}

class ArtistCompare implements Comparator<SongV3> {
    
    @Override
  public int compare(SongV3 one, SongV3 two) {
//compareTo() method from the String class      
    return one.getArtist().compareTo(two.getArtist()); 
  }
}
