package ch10;

//Initializing a final static variable

public class ConstantInit3 {
  public static final double VAL;

//Option 2: 
//This code runs when class is loaded and 
//before any static method is called, and 
//before any static variable can be used  
  static {
    VAL = Math.random();
  }
}