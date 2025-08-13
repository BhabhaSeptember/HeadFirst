package ch10;

class ConstantInit1 {
  final static int X;

//Static initializer, a block of code that runs when a class is loaded,
//before any other code can use the class,
//Therefore it can be used to initialize static final variables/Constants  
  static {
    X = 42;
  }
}