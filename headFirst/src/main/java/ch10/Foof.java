package ch10;

//NOTE: 
//1) Final variable means we cannot change its value
//2) Final method means we cannot override the method
//3) Final class means it cannot be extended by any subclasses

//Assigning final instance variables is done either at the time is is declared
//or in the constructor
class Foof {
//instance variable 'size' value cannot be changed     
  final int size = 3;
  
//declaring a final intance variable (initialized below)  
  final int whuffie;

  Foof() {
//now, this instance variable value cannot be changed      
    whuffie = 42;
  }

  
//final variable in method parameter  
  void doStuff(final int x) {
    // you can’t change x
  }

  void doMore() {
//local variable value cannot be changed      
    final int z = 7;
    // you can’t change z
  }
}
     
