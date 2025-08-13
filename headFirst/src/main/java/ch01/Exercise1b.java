package ch01;

// class declaration intentionally missing in exercise

//line of code below had to be added
//classes need a class declaration to be interpreted by JVM as a class
public class Exercise1b {
  public static void main(String [] args) {      
    int x = 5;
    while ( x > 1 ) {
      x = x - 1;
      if ( x < 3) {
        System.out.println("small x");
      }
    }
  }
}
