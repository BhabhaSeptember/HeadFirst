package ch09;


public class DeRef {
  Duck d = new Duck();

  public void go() {
//Deprogramming an object reference, abandons the object it was referencing, 
//in heap
//Cannot invoke any methods or access any instance variables using dot operator
    d = null;
  }
}
