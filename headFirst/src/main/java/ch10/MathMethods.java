package ch10;

public class MathMethods {

  static void random() {
//'random()' returns double from 0.0 to just below 1.0
//i.e. a range that includes 0.0 but excludes 1.0
    double r1 = Math.random();
    System.out.println("r1 = " + r1);
    int r2 = (int) (Math.random() * 5);
    System.out.println("r2 = " + r2);
  }

  static void abs() {
//the 'abs()' method is overloaded so we can pass int and double args      
    int x = Math.abs(-240);       // returns 240
    double d = Math.abs(240.45);  // returns 240.45
  }

  static void round() {
//returns int if a float is passed as an arg
    int x = Math.round(-24.8f);  // returns -25
    System.out.println("x = " + x);
    int y = Math.round(24.45f);  // returns 24
    System.out.println("y = " + y);

//returns long if double is passed as an arg    
    long z = Math.round(24.45);  // returns 24L
    System.out.println("z = " + z);
  }

  static void min() {
//returns the smallest value between the two args
//method is overloaded so it takes, ints, longs, floats or doubles
    int x = Math.min(24,240);  // returns 24
    System.out.println("x = " + x);

    double y = Math.min(90876.5, 90876.49);  // returns 90876.49
    System.out.println("y = " + y);
  }

  static void max() {
//returns the largest value between the two args
//method is overloaded so it takes, ints, longs, floats or doubles
    int x = Math.max(24,240);  // returns 240
    System.out.println("x = " + x);
    double y = Math.max(90876.5, 90876.49);  // returns 90876.5
    System.out.println("y = " + y);
  }

  static void sqRt() {
//returns positive square root of arg      
    double x = Math.sqrt(9);    //return 3
    System.out.println("x = " + x);
    double y = Math.sqrt(42.0); // returns 6.48074069840786
    System.out.println("y = " + y);
  }


  public static void main(String[] args) {
    sqRt();
  }
}
