package ch01;

class Exercise1a {
  public static void main(String[] args) {
      
//I added code that will prevent an infinite loop
//we increment x by 1 after every loop so eventually the condition will become false
    int x = 1;
    while (x < 10) {
      if (x > 3) {
        System.out.println("big x");     
      }
      x++; //added line of code
    }
  }
}