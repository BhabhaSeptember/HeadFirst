package ch04;

//SUMMARY:
//This program demonstrates method parameter passing and basic return logic 
//using a simple go() method that doubles a number
//
//1) Main Method
//orig is initialized to 42
//A new XCopy object is created
//Calls the go() method with orig (42) as the argument.
//The return value (42 × 2 = 84) is stored in y, Prints: 42 84
//
//2) go Method
//Takes a copy of the value of orig (since primitives are passed by value in Java).
//Doubles it and returns the result
class XCopy {

//I dont see anything wrong with this code    
  public static void main(String[] args) {
    int orig = 42;
    XCopy x = new XCopy();
    int y = x.go(orig);
    System.out.println(orig + " " + y);
  }

  int go(int arg) {
    arg = arg * 2;
    return arg;
  }
}