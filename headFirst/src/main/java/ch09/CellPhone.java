package ch09;

//A class with an object reference instance variable stores the reference variable,
//in the heap along with any other primitive instance variables

//Only if that object reference is instantiated, will space be created,
//in heap for that object

public class CellPhone {
//Antenna object reference variable created in heap memory
  private Antenna ant; 
//  --- vs ---
//new Antenna object created in heap memory with reference variable sitting inside, 
// Cellphone class
  private Antenna ante = new Antenna();

  
  private class Antenna {
  }
}