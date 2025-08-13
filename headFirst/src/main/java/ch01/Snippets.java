package ch01;

public class Snippets {
    
    public static void main(String[] args) {
        Snippets s = new Snippets();
        
        s.statements();
        
        s.looping(20);
        
        s.conditions(10, "Dirk");
        s.conditions(2, "Dirk");
        
        s.booleanTests();
        
    }//end of main method
    
  void statements() {
    int x = 3;
    String name = "Dirk";
    x = x * 17;
    System.out.println("x is " + x);
    double d = Math.random();
    // this is a comment
  }

  void looping(int x) {
    while (x > 12) {
      x = x - 1;
    }

    for (int i = 0; i < 10; i = i + 1) {
      System.out.println("i is now " + i);
    }
  }

  void conditions(int x, String name) {
    if (x == 10) {
      System.out.println("\nx must be 10");
    } else {
      System.out.println("x isn't 10");
    }
    if ((x < 3) & (name.equals("Dirk"))) {
      System.out.println("Gently");
    }
    System.out.println("this line runs no matter what");
  }

  void booleanTests() {
    int x = 4; // assign 4 to x
    while (x > 3) {
      // loop code will run because
      // x is greater than 3
      x = x - 1; // or we’d loop forever
    }
    int z = 27; //
    while (z == 17) {
      // loop code will not run because
      // z is not equal to 17
    }
  }
}
