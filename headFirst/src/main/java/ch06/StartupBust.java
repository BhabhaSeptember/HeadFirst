package ch06;

import java.util.ArrayList;

public class StartupBust {
//----- Page 146 Exercise -----
//--- Annotating the code below --- 
    
//1. Declare and initialize the variables we will need
  private GameHelper helper = new GameHelper();
  private ArrayList<Startup> startups = new ArrayList<Startup>();
  private int numOfGuesses = 0;

  private void setUpGame() {
    // first make some Startups and give them locations
    
//2. Make three Startup objects, Give them names and add them to ArrayList
    Startup one = new Startup();
    one.setName("poniez");
    Startup two = new Startup();
    two.setName("hacqi");
    Startup three = new Startup();
    three.setName("cabista");
    startups.add(one);
    startups.add(two);
    startups.add(three);

//3. Print brief instructions for the user    
    System.out.println("Your goal is to sink three Startups.");
    System.out.println("poniez, hacqi, cabista");
    System.out.println("Try to sink them all in the fewest number of guesses");

//4. Repeat with each Startup in the list    
    for (Startup startup : startups) {
//5. Ask the helper for a Startup location i.e an ArrayList of String     
      ArrayList<String> newLocation = helper.placeStartup(3);
//6. Call setter method on this Startup, give it location we got from helper
      startup.setLocationCells(newLocation);
    } // close for loop
  } // close setUpGame method

  private void startPlaying() {
//7. As long as Startup list is NOT empty      
    while (!startups.isEmpty()) {
//8. Get user input        
      String userGuess = helper.getUserInput("Enter a guess");
//9. Call our own checkUserGuess method      
      checkUserGuess(userGuess);
    } // close while
//10. Call our own finishGame method    
    finishGame();
  } // close startPlaying method

  
  
  private void checkUserGuess(String userGuess) {
//11. Increment the number of guesses the user has made      
    numOfGuesses++;
//12. Assume it's a miss unless told otherwise    
    String result = "miss"; // assume a miss until told otherwise

//13. Repeat with all Startups in the list    
    for (Startup startupToTest : startups) {
//14. Ask the Startup to check user guess looking for a hit or kill        
      result = startupToTest.checkYourself(userGuess);
      
      if (result.equals("hit")) {
//15. Get out of the loop early, no point in testing the others
        break;
      }
      if (result.equals("kill")) {
//16. This ones dead, take it out of the Startups list then get out of loop          
        startups.remove(startupToTest); // he's gone
        break;
      }
    } // close for

//17. Print the result for the user    
    System.out.println(result);
  } // close method

  private void finishGame() {
//18. Print message telling user how they did in the game      
    System.out.println("All Startups are dead! Your stock is now worthless");
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println("You got out before your options sank.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options");
    }
  } // close method

  public static void main(String[] args) {
//19. Create the game object      
    StartupBust game = new StartupBust();
//20. Tell the game object to set up the game    
    game.setUpGame();
//21. Tell game object to start the main game play loop,
//i.e. keep asking for user input & checking the guess
    game.startPlaying();
  } // close method
}