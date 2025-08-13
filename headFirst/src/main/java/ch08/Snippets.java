package ch08;

import ch07.Dog;

public class Snippets {
    
  public void go() {
    Dog aDog = new Dog();
//Below will compile because we assign result of method to Object reference type,
//the same type which the method returns
    Object sameDog = getObject(aDog);
  }

  public Object getObject(Object o) {
    return o;
  }
}//end of Snippets class

class BadDog {
  public void go() {
    Dog aDog = new Dog();
// Below line doesn't compile because compiler recognizes it as Object type,
//not a Dog type so cannot assign it to a Dog reference
//    Dog sameDog = getObject(aDog); //uses getObject method from below
  }

//Method returns an Object type  
  public Object getObject(Object o) {
    return o;
  }
  
}//end of BadDog class