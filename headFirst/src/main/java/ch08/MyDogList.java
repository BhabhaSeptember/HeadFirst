package ch08;

import ch07.Dog;

public class MyDogList {
  
//Dog type array to hold Dog objects with length of 5    
  private Dog[] dogs = new Dog[5];
  
//Instance variable to keep track of element index numbers  
  private int nextIndex = 0;

//Add method that takes in a Dog object argument  
  public void add(Dog d) {
//If nextIndex is within array length limit      
    if (nextIndex < dogs.length) {
//Assign the method argument's created Dog object to specified index in dogs array        
      dogs[nextIndex] = d;
//Print index number with label      
      System.out.println("Dog added at " + nextIndex);
//Increment index number by 1      
      nextIndex++;
    }
  }
}