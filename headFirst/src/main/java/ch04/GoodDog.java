package ch04;

//Encapsuation
//Declare instance variables as private fields to prevent direct access
//Create setter methods instead for ability to control acceptable values later

class GoodDog {
//Private int size instance variable declared    
  private int size;

//Public getter and setter methods below  
  public int getSize() {
    return size;
  }

  public void setSize(int s) {
    size = s;
  }

  void bark() {
    if (size > 60) {
      System.out.println("Wooof! Wooof!");
    } else if (size > 14) {
      System.out.println("Ruff!  Ruff!");
    } else {
      System.out.println("Yip! Yip!");
    }
  }
}

