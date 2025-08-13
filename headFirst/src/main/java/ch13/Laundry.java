package ch13;

//EXAMPLE 1: DECLARING MULTIPLE EXCEPTIONS
//Method declares two exceptions
// public class Laundry {
//  public void doLaundry() throws PantsException, LingerieException {
//    // code that could throw either exception
//  }
// }

//EXAMPLE 2: DECLARE EXAMPLES USING SUPERCLASS
public class Laundry {
//Throwing the superclass exceptions allows us to throw any subclass of 
//ClothingException e.g. PantsException, LingerieException, TeeShirtException, etc
//without explicitly declaring them individually    
  public void doLaundry() throws ClothingException {
    // code that could throw either exception
  }
}