package ch09;

//Overloaded constructors must have different argument lists,
//i.e. order and type of arguments must be different

public class Mushroom {
  public Mushroom(int size) {
  }

  public Mushroom() {
  }

  public Mushroom(boolean isMagic) {
  }

  public Mushroom(boolean isMagic, int size) {
  }

  public Mushroom(int size, boolean isMagic) {
  }
}