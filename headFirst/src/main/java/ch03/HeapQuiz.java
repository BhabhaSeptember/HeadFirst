package ch03;

//SUMMARY:
//This program demonstrates object reference manipulation, array assignment, and 
//the concept of object eligibility for garbage collection in Java.
//
//1) Class Definition
//HeapQuiz has an instance variable id.
//main() creates an array of HeapQuiz references
//
//2) Object Creation Loop:
//The first 3 array elements (hq[0], hq[1], and hq[2]) are initialized with 
//new HeapQuiz objects and assigned IDs 0, 1, and 2
//
//3) Reference Reassignments:
//Statement             Effect
//hq[3] = hq[1];	hq[3] points to same object as hq[1] (id 1)
//hq[4] = hq[1];	hq[4] also points to object with id 1
//hq[3] = null;         hq[3] no longer points to anything
//hq[4] = hq[0];	hq[4] now points to object with id 0
//hq[0] = hq[3];	hq[0] is set to null (hq[3] is null)
//hq[3] = hq[2];	hq[3] now points to object with id 2
//hq[2] = hq[0];	hq[2] becomes null (hq[0] is null)

class HeapQuiz {
  int id = 0;

  public static void main(String[] args) {
    int x = 0;
    HeapQuiz[] hq = new HeapQuiz[5];
    
    while (x < 3) {
      hq[x] = new HeapQuiz();
      hq[x].id = x;
      x = x + 1;
    }//end of while loop
    
    hq[3] = hq[1];
    hq[4] = hq[1];
    hq[3] = null;
    hq[4] = hq[0];
    hq[0] = hq[3];
    hq[3] = hq[2];
    hq[2] = hq[0];
    // do stuff
  }
}  

// ----- Page 66 Exercise -----

//hq[0] ---> null
//hq[1] ---> id = 1
//hq[2] ---> null
//hq[3] ---> id = 2
//hq[4] ---> id = 0