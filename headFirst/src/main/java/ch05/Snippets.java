package ch05;

public class Snippets {
//Use for loop if you know how many iterations you need    
  void forLoop() {
    for (int i = 0; i < 8; i++) {
      System.out.println(i);
    }
    System.out.println("done");
  }

//Use while loop if you dont know how many iterations you need
//The loop contiues until boolean expression becomes false  
  void whileLoop() {
    int i = 0;
    while (i < 8) {
      System.out.println(i);
      i++;
    }
    System.out.println("done");
  }

}
