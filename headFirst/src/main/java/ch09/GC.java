package ch09;

public class GC {
    
  public static GC doStuff() {
    GC newGC = new GC();
    doStuff2(newGC);
    return newGC;
  }

  public static void main(String[] args) {
    GC gc1;
    GC gc2 = new GC();
    GC gc3 = new GC();
    GC gc4 = gc3;
    gc1 = doStuff();

    //CANDIDATE GOES HERE...
//    newGC = gc3;
    // call more methods
  }

  public static void doStuff2(GC copyGC) {
    GC localGC = copyGC;
  }
}

// ----- Page 268 Exercise -----

//1) ANSWER: NO, the line of code below tries to access variable copyGC which
//has become out of scope
//
//copyGC = null;


//2) ANSWER: YES, the object that was referenced by gc2 has no other reference
//value, associated with it so deprogramming gc2 to null leaves that object
//unreferenced and eligible for garbage collection
//
//gc2 = null;


//3) ANSWER: NO, newGC became out of scope once doStuff() method finished 
//execution, so we cannot access that variable inside the main method
//
//newGC = gc3;


//4) ANSWER: YES, gc1 was a reference variable for an object created using newGC,
//so deprogramming it to null results in object eligible for garbage collection
//
//gc1 = null;


//5) ANSWER: NO, newGC is out of scope in the main method 
//
//newGC = null;


//6) ANSWER: NO, gc3 is still a reference variable for that same object which
//gc4 was also referencing
//
//gc4 = null;


//7) ANSWER: NO, gc4 would still reference the object that gc3 had been 
//referencing prior to being reassigned to reference gc2's object
//
//gc3 = gc2;


//8) ANSWER: YES, the object referenced by gc1 has no other reference variable
//in-scope so reassigning it's reference variable to gc4's object, leaves it
//eligible for garbage collection
//
//gc1 = gc4;


//9) ANSWER: NO, gc4 still references that object so deprogramming the gc3 
//reference variable to null does not affect gc4 still referencing to it
//
//gc3 = null;
