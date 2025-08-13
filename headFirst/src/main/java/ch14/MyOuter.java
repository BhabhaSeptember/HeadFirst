package ch14;

class MyOuter {
  private int x;
  
//Instantiating an inner class within outer class therefore
//the inner object will 'bond' with outer object  
// NOTE: If method instantiates an inner class, the inner object
//will 'bond' to the instance whose method is running
  private MyInner inner = new MyInner();

    public static void main(String[] args) {
        MyOuter outer = new MyOuter();
        outer.doStuff();
    }
  
  public void doStuff() {
    inner.go();
  }

//Inner class has access to all variables and methods of the outer 
// class including private fields & methods
  
  class MyInner {
    void go() {
      x = 42;
        System.out.println("Inner class says x = 42");
    }
  }//close inner class

}//close outer class
