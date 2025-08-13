package ch04;

class AddThing {
  int a;
  int b = 12;

  public int add() {
//Local variables declared within a method and must be initialized before use      
    int total = a + b;
    return total;
  }
}