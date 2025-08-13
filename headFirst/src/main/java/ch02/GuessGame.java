package ch02;

public class GuessGame {
//Declare 3 instance variables for three Player class objects    
  Player p1;
  Player p2;
  Player p3;

  public void startGame() {
//Create 3 Player objects & assign to 3 instance variables      
    p1 = new Player();
    p2 = new Player();
    p3 = new Player();

//Declare 3 variables to hold guesses that the 3 Player objects will make    
    int guessp1 = 0;
    int guessp2 = 0;
    int guessp3 = 0;

//Declare 3 boolean variables to hold true/false based on Player's answers    
    boolean p1isRight = false;
    boolean p2isRight = false;
    boolean p3isRight = false;

//Declare targetNumber variable for Player's to guess
//Assign a random integer to that variable
    int targetNumber = (int) (Math.random() * 10);
    System.out.println("I'm thinking of a number between 0 and 9...");

    while (true) {
      System.out.println("Number to guess is " + targetNumber);

//Call each Player's guess() method      
      p1.guess();
      p2.guess();
      p3.guess();

//Access Player's number variable which holds result from the guess() method 
//i.e. each Player's randomly generated guess number
      guessp1 = p1.number;
      System.out.println("Player one guessed " + guessp1);

      guessp2 = p2.number;
      System.out.println("Player two guessed " + guessp2);

      guessp3 = p3.number;
      System.out.println("Player three guessed " + guessp3);

//Check each Player's against the targetNumber
//If true, then set players boolean variable to true
      if (guessp1 == targetNumber) {
        p1isRight = true;
      }
      if (guessp2 == targetNumber) {
        p2isRight = true;
      }
      if (guessp3 == targetNumber) {
        p3isRight = true;
      }

//If any of the players guessed correctly the strings below will be printed      
      if (p1isRight || p2isRight || p3isRight) {

        System.out.println("We have a winner!");
        System.out.println("Player one got it right? " + p1isRight);
        System.out.println("Player two got it right? " + p2isRight);
        System.out.println("Player three got it right? " + p3isRight);
        System.out.println("Game is over.");
        break; // game over, so break out of the loop
      } else {
        // we must keep going because nobody got it right!
        System.out.println("Players will have to try again.");
      } // end if/else
    } // end loop
  } // end method
} // end class