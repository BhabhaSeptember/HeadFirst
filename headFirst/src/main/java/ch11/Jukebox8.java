package ch11;

import java.util.*;

public class Jukebox8 {
  public static void main(String[] args) {
    new Jukebox8().go();
  }

  public void go() {
//Created a MockMoreSongs class to return a List of SongV3 objects that,
//contain same values as SongListMore.txt file (with duplicates)
    List<SongV3> songList = MockMoreSongs.getSongsV3();
    System.out.println(songList);

    songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
    System.out.println(songList);

//Set must hold SongV3 objects
//HashSet constructor takes a Collection and creates a set with,
//all the items from that collection
    Set<SongV3> songSet = new HashSet<>(songList);
    System.out.println(songSet);
  }
}
