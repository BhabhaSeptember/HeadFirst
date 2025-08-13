package ch02;

class Episode {
  int seriesNumber;
  int episodeNumber;

//play() method below had to be added for the Test class to compile
//Test class was previously calling a method that didnt exist in this class  
  void play() {
    System.out.println("Playing episode " + episodeNumber);
  }

  void skipIntro() {
    System.out.println("Skipping intro...");
  }

  void skipToNext() {
    System.out.println("Loading next episode...");
  }
}

