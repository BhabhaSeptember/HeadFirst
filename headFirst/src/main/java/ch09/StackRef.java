package ch09;

//THE STACK: Contains method invocations and local variables
//local variables that are objects store variable reference in stack but
//the actual object is stored in heap memory
//THE HEAP: Contains all objects and their instance variables

public class StackRef {
  public void foof() {
    barf();
  }

  public void barf() {
//Duck object reference variable is declared as local variable for the method,      
//therefore, object reference 'd' will be in stack frame of barf() method
//But the object itself sits in heap memory, 
//regardless of whether reference is local/instance variable
    Duck d = new Duck(24);
  }
}