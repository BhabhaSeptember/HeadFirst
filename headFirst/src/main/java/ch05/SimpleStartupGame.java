package ch05;

public class SimpleStartupGame {
  public static void main(String[] args) {
//Declare & initialize variable to track number of guesses a user makes      
    int numOfGuesses = 0;
//Helper class with method to get user input    
    GameHelper helper = new GameHelper();

//Create Startup object    
    SimpleStartup theStartup = new SimpleStartup();
//Generate a random number between 0 and 5 for cell 1 i.e. (0, 1, 2, 3,or 4)    
    int randomNum = (int) (Math.random() * 5);

//Use random number to create locations array    
    int[] locations = {randomNum, randomNum + 1, randomNum + 2};
//Assign cell locations for Startup object    
    theStartup.setLocationCells(locations);
//Create boolean variable to track if game is still ongoing 
//i.e. Startup object is still alive    
    boolean isAlive = true;
    
//Boolean used in while loop to repeat game until Startup is dead/killed
    while (isAlive) {
//Get user input        
      int guess = helper.getUserInput("enter a number");
//Startup calls method to check the guess      
      String result = theStartup.checkYourself(guess);
//Increment number of guesses by 1      
      numOfGuesses++;
//If result of checking the guess is 'kill', we toggle boolean to NOT ALIVE
//We exit the while loop and print the user guess count
      if (result.equals("kill")) {
        isAlive = false;
        System.out.println("You took " + numOfGuesses + " guesses");
      } // close if
    } // close while
  } // close main

}
