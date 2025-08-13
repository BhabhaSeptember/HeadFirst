package ch10;

//NOTE: 
//Static variables are shared meaning all instances share a single copy

public class Duck {
  private int size;
//one value per class instead of one value per instance
//static variable below is initialized only when class is first loaded,
//not each timea new instance of Duck is made  
  private static int duckCount = 0;  

  public Duck() {
//so duckCount will incrememnt each time the constructor runs,
//i.e. it wont be reset to 0 each time a new instance of Duck is created
    duckCount++;
  }

  public void setSize(int s) {
    size = s;
  }

  public int getSize() {
    return size;
  }
}