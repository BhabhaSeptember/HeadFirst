package ch03;

//SUMMARY
//This program demonstrates how to create objects, assign values to their fields, 
//store them in an array, and call methods on them — specifically using a Dog 
//class with a name and a bark() method

class Dog {
  String name;

  public static void main(String[] args) {
// make a Dog object and access it

//Declare a reference variable called dog1 for a Dog object of type Dog    
    Dog dog1 = new Dog();
//Call the bark method on the object which is referenced by dog1    
    dog1.bark();  
//Assign value of Bart to the name instance variable of the object referenced by dog1   
//Strings are special type of object, can be created & assigned like primitives
    dog1.name = "Bart";

    // now make a Dog array
    Dog[] myDogs = new Dog[3];
    // and put some dogs in it
    myDogs[0] = new Dog();
    myDogs[1] = new Dog();
    myDogs[2] = dog1;

    // now access the Dogs using the array
    // references
    myDogs[0].name = "Fred";
    myDogs[1].name = "Marge";

    // Hmmmm... what is myDogs[2] name?
    System.out.print("last dog’s name is ");
    System.out.println(myDogs[2].name);

    // now loop through the array
    // and tell all dogs to bark
    int x = 0;
    while (x < myDogs.length) {
      myDogs[x].bark();
      x = x + 1;
    }
  }

  public void bark() {
    System.out.println(name + " says Ruff!");
  }

  public void eat() {
  }

  public void chaseCat() {
  }
}