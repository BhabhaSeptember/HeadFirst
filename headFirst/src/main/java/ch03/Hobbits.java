package ch03;

//SUMMARY:
//This program creates an array of Hobbits, assigns names to each Hobbit object, 
//and prints a message for each one
//1) Class Definition:
//Hobbits has a single instance variable: String name.
//2) In main() method:
//A Hobbits[] array h of size 3 is declared: can hold 3 Hobbits objects.
//z is initialized to -1.
//3) Loop (from z = 0 to 2):
//In each iteration:
//A new Hobbits object is created at index z.
//Default name is "bilbo".
//If z == 1, name is changed to "frodo".
//If z == 2, name is changed to "sam".
//It prints: "<name> is a good Hobbit name"

class Hobbits {
  String name;

//The array has a size of 3 elements 
  public static void main(String[] args) {
    Hobbits[] h = new Hobbits[3];
    int z = -1; //fixed line of code
 
//Changing condition to accomodate size of array which ends with index 2    
    while (z < 2) { //fixed line of code
//initializing int z above to -1 ensures we start inserting at index 0
      z = z + 1; 
      h[z] = new Hobbits();
      h[z].name = "bilbo";
      if (z == 1) {
        h[z].name = "frodo";
      }
      if (z == 2) {
        h[z].name = "sam";
      }
      System.out.print(h[z].name + " is a ");
      System.out.println("good Hobbit name");
    }
  }
}