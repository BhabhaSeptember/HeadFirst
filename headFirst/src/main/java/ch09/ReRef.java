package ch09;

public class ReRef {
//Below is an example of an instance variable for ReRef object,
//it declares a Duck object reference variable and assigns a new, 
//Duck object to it    
  Duck d = new Duck();

  public void go() {
//When 'go()' method is called, the reference variables is reassigned to,
//a new Duck object, so previous object is abandoned in heap for 
//garbage collection
    d = new Duck();
  }
}