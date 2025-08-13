package ch11;

import java.util.*;

public class Jukebox10 {
  public static void main(String[] args) {
    new Jukebox10().go();
      System.out.println("\n=========================\n");
    new Jukebox10().go2();
  }

  public void go() {
    List<SongV4> songList = MockMoreSongs.getSongsV4();
    System.out.println(songList);

    songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
    System.out.println(songList);

//Create TreeSet instead of HashSet
//We pass a list into the TreeSet constructor so it behaves like a sort() method
//TreeSet will use SongV4's compareTo() method to sort songList items by title
    Set<SongV4> songSet = new TreeSet<>(songList);
    System.out.println("by title: " + songSet);
  }

  public void go2() {
    List<SongV4> songList = MockMoreSongs.getSongsV4();

//Pass lambda expression into TreeSet constructor to sort by Song bpm
//This lambda implements Comparator
    Set<SongV4> songSet = new TreeSet<>((o1, o2) -> o1.getBpm() - o2.getBpm());
    songSet.addAll(songList);
    System.out.println("by bpm: " + songSet);
  }
}
