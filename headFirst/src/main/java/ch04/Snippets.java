package ch04;

public class Snippets {
  void createSongs() {
    Song song1 = new Song();
    song1.setArtist("Travis");
    song1.setTitle("Sing");
    Song song2 = new Song();
    song2.setArtist("Sex Pistols");
    song2.setTitle("My Way");
  }

  void go() {
    TestStuff t = new TestStuff();
    t.takeTwo(12, 34);
  }

  void comparingVariables() {
//The == operator looks at the pattern of bits in the variable
//So two reference variables refering to the same object will be the same, 
//according to the == operator
    Foo a = new Foo();
    Foo b = new Foo();
    Foo c = a;
    if (a == b) { // false }
      if (a == c) { // true }
        if (b == c) { // false }
        }
      }
    }
  }
}

class Song {
  private String artist;
  private String title;

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getArtist() {
    return artist;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }
}

class TestStuff {
  void takeTwo(int x, int y) {
    int z = x + y;
    System.out.println("Total is " + z);
  }
}
