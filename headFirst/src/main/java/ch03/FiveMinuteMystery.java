package ch03;

//SUMMARY
//This code shows two approaches to creating multiple Contact objects and 
//highlights a common mistake when handling object references in Java.
//
//solution1() — Correct approach:
//Creates an array contacts of size 10 to hold references to 10 distinct Contact 
//objects.
//Uses a while loop to instantiate a new Contact for each array element.
//Each Contact object is preserved because each has its own reference in the array.
//Result: All 10 Contact objects are accessible individually through the array.
//
//solution2() — Problematic approach:
//Uses a single reference variable contactRef.
//In the loop, repeatedly creates a new Contact and assigns it to contactRef.
//Each new assignment overwrites the previous reference, so only the last created
//Contact is referenced.
//All earlier Contact objects become unreachable and are lost (eligible for
//garbage collection).
//Result: Only one Contact object is accessible (the last one created)

public class FiveMinuteMystery {
  void solution1() {
    int x = 0;
    Contact[] contacts = new Contact[10];
    while (x < 10) {   // make 10 contact objects
      contacts[x] = new Contact();
      x = x + 1;
    }
    // do complicated Contact list updating with contacts
  }

//The issue with the code below is: 
//There is only one reference variable for all added contacts (contactRef)
//When creating a new Contact object, 
//the previous object loses the reference so cannot be accessed anymore  
  void solution2() {
    int x = 0;
    Contact contactRef;
    while ( x < 10 ) {   // make 10 contact objects
      contactRef = new Contact();
      x = x + 1;
    }
    // do complicated Contact list updating stuff with contactRef
  }

}

class Contact {
}
