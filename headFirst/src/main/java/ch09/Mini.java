package ch09;

import java.awt.Color;

class Mini extends Car {
    
    public static void main(String[] args) {
        Mini mini = new Mini();
    }
    
  private Color color;

//'this()' keyword is used to call a constructor from another overloaded constructor,
//in the same class

//Both Mini constructors do the same thing so we avoid code duplication, 
//by using 'this()' keyword
  public Mini() {
    this(Color.RED);//'this()' is reference to current object
  }

//The REAL constructor that initializes this object including,
//the call to super() which is superclass "Color" constructor  
  public Mini(Color c) {
    super("Mini");
    color = c;
    // more initialization
  }

  public Mini(int size) {
    this(Color.RED);
//won't compile because we cannot have a call to superclass constructor with,
//a constructor that calls another constructor in same class using 'this()' keyword
//    super(size); //compiler error occurs here
  }
}
