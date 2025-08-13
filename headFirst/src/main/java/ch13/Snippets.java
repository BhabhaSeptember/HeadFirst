package ch13;

public class Snippets {
  private boolean abandonAllHope = true;
  private Snippets anObject;
  private Laundry laundry;
  
  
//FLOW CONTROL IN TRY/CATCH BLOCKS
//1) If try succeeds i.e. doRiskyThing() does not throw an exception,
//the first try block will run then the code below the catch block will run
//e.g. output: We Made it
//
//2) If try block fails i.e. doRiskyThing() throws an exception,
//the try block runs, after the call to doRiskyThing(), the rest of code 
//does not run. The catch block will run instead and thereafter, the method
//continues.... 
//e.g. output: failed /n We made it!  
  void testTryCatch() {
    try {
      Risky x = new Risky();
      Foo f = x.doRiskyThing();
      int b = f.getNum();

    } catch (Exception e) {
      System.out.println("failed");
    }
    System.out.println("We made it!");
  }

  
//BELOW is exception throwing code  
//This method declares that it throws a BadException 
  public void takeRisk() throws BadException {
    if (abandonAllHope) {
//the method creates a new Exception object and throws it        
      throw new BadException();
    }
  }

//CODE calls risky method above ( takeRisk() )  
  public void crossFingers() {
    try {
      anObject.takeRisk();
    } catch (BadException e) {
      System.out.println("Aaargh!");
      e.printStackTrace(); //method inherited from parent Throwable class
    }
  }

  void catchExceptions() {
//    try {
//      laundry.doLaundry();
//
//    } catch (ShirtException shex) {
//      // recovery code
//    }
  }

}//END OF SNIPPETS CLASS

class Risky {
  public Foo doRiskyThing() {
    return null;
  }
}

class Foo {
  public int getNum() {
    return 0;
  }
}
