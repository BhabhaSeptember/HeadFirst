package ch11;

import java.util.*;

//NATURAL ORDERING USING COLLECTIONS SORT METHOD: 
//some special characters first -> numbers ->some more special characters ->
//then uppercase -> lowercase

public class Jukebox1 {
  public static void main(String[] args) {
    new Jukebox1().go();
  }

  public void go() {
    List<String> songList = MockSongs.getSongStrings();
    System.out.println(songList);
    // Next step adds the following
    
//Sorting the list of songs using "natural ordering"    
    Collections.sort(songList);
    System.out.println(songList);
  }
}
