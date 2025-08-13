package ch01;

class Exercise1c {
  // method declaration intentionally missing in exercise
    
//code below had to be added
//class cannot compile without a main method
//JVM runs the code it find inside the main method of a class    
  public static void main(String[] args) {
    int x = 5;
    while (x > 1) {
      x = x - 1;
      if (x < 3) {
        System.out.println("small x");
      }
    }
  }
}