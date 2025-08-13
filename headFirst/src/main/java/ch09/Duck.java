package ch09;

public class Duck {
  int size;

//Compiler's default class constructor
//Constructor is different from method because theres no return type between,
//access modifier and class name  
//Constructor code runs when we use 'new' keyword during object instantiation  
  public Duck() {
  }

//Constructor below takes one int argument, 
//allowing object's initial values to be set during initialization
//i.e. set value for instance variable 'size' from constructor argument  
  public Duck(int duckSize) {
    System.out.println("Quack");

    size = duckSize;

    System.out.println("size is " + size);
  }
}

// terrible way to provide a default value:
//public Duck(int newSize) {
//  if (newSize == 0) {
//    size = 27;
//  } else {
//    size = newSize;
//  }
//}
