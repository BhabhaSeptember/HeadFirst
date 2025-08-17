package ch18;

//To prevent subclasses from extending this class and adding mutable values,
//we declare an immutable with 'final' keyword
public final class ImmutableData {
    
//All fields should be 'final'. Their values will be set once in the
//field declaration or constructor    
  final String name;
  final int value;

// All fields need to be initialized once, usually in the constructor
  public ImmutableData(String name, int value) {
    this.name = name;
    this.value = value;
  }

//Immutable objects have getters but no setters because they should not be 
//changed in any method  
  public String getName() { return name; }

  public int getValue() { return value; }
}
