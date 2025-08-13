package ch09;

// ----- Page 259 Exercise -----

public class Boo {
    
  public Boo(int i) { }
  
  public Boo(String s) { }
  
  public Boo(String s, int i) { }
  
}//end of Boo method


class SonOfBoo extends Boo {
    
  public SonOfBoo() {
    super("boo");
  }

  public SonOfBoo(int i) {
    super("Fred");
  }

  public SonOfBoo(String s) {
    super(42);
  }

//ANSWER: There is no super(...) call, so Java tries to implicitly call super(),
//but Boo superclass has no zero-arg constructor
//  
//ERROR MESSAGE:  
//  %javac SonOfBoo.java
//cannot resolve symbol
//symbol: constructor Boo()
//  
//  public SonOfBoo(int i, String s) {
//  }

  
//ANSWER: super tries to call Boo(String, String), which doesnt exist, 
//in superclass Boo... 
//  
//ERROR MESSAGE: 
//%javac SonOfBoo.java
//cannot resolve symbol
//symbol : constructor Boo(java.lang.String, java.lang.String)  
//  
//  public SonOfBoo(String a, String b, String c) {
//    super(a, b);
//  }

  public SonOfBoo(int i, int j) {
    super("man", j);
  }

//ANSWER: super tries to call Boo(int, String), which does not exist in superclas,
//only Boo(String, int) constructor exists in superclass (order of args matters)   
//
//ERROR MESSAGE:
//  %javac SonOfBoo.java
//cannot resolve symbol
//symbol : constructor Boo(int, java.lang.String)
//  
//  public SonOfBoo(int i, int x, int y) {
//    super(i, "star");
//  }
  
}//end of SonOfBoo class
       