package ch01;

//public class DooBee {
//  public static void main(String[] args) {
//    int x = 1;
//    while (x < 3) {
//      System.out.print("Doo");
//      System.out.print("Bee");
//      x = x + 1;
//    }
//    if (x == 3) {
//      System.out.print("Do");
//    }
//  }//end of main method
//}//end of class


//----- Page 15 exercise -----
//% java DooBee
//DooBeeDooBeeDo

//SUMMARY
//Step-by-step Execution:
//x = 1 → loop starts (x < 3)
//
//Prints: DooBee
//
//x = 2
//
//x = 2 → still < 3
//
//Prints: DooBee
//
//x = 3
//
//x = 3 → loop ends
//
//if (x == 3) is true:
//
//Prints: Do

//In Short:
//The loop prints "DooBee" twice.
//
//After the loop, it prints "Do" once.
//
//So the total output is: DooBeeDooBeeDo

 public class DooBee {
 
  public static void main (String[] args) {
    int x = 1;
    while (x < 3) {
      System.out.print("Doo");
      System.out.print("Bee");
      x = x + 1;
    }
    if (x == 3) {
      System.out.print("Do");
    }
  }
 
 }


