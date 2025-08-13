package ch11;

import java.util.List;

public class TestGenerics1 {
  public static void main(String[] args) {
//Create list of unmodifiable objects using factory method 'List.of()'      
    List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());
    takeAnimals(animals);
  }

//method has a generic class(List) as a parameter  
  public static void takeAnimals(List<Animal> animals) {
//note: we can only call methods declared in Animal class because,
//the method parameter is of type List<Animal>
    for (Animal a : animals) {
      a.eat();
    }
  }
}

abstract class Animal {
  void eat() {
    System.out.println("animal eating");
  }
}

class Dog extends Animal {
  void bark() {
  }
}

class Cat extends Animal {
  void meow() {
  }
}
	
	