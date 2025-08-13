package ch05;

//TEST CODE

public class SimpleStartupTestDrive {
  public static void main(String[] args) {
//Instantiate SimpleStartup object      
    SimpleStartup dot = new SimpleStartup();

//Create int arrau for location of Startup cells,
//(3 consecutive ints out of a possible 7) 
    int[] locations = {2, 3, 4};
//Invoke setter method on Startup    
    dot.setLocationCells(locations);

//Simulate a fake guess    
    int userGuess = 2;
//Invoke checkYourself() method on Startup object & pass the fake guess    
    String result = dot.checkYourself(userGuess);
    
    String testResult = "failed";
//If fake guess gives back 'hit', test is working    
    if (result.equals("hit")) {
      testResult = "passed";
    }
//Print out result of test (passed or failed)    
    System.out.println(testResult);
  }
}

class SimpleStartup {
  private int[] locationCells;
  private int numOfHits = 0;

  public void setLocationCells(int[] locs) {
    locationCells = locs;
  }

  public String checkYourself(int guess) {
//Variable to hold result we return, default is a miss      
    String result = "miss";
    
//Repeat code block with each cell location of the object    
    for (int cell : locationCells) {
//Compare user guess to this cell/element in array        
      if (guess == cell) {          
        result = "hit";
        numOfHits++;
        break; //Break out of loop, no need to test other cells
      } // end if
    } // end of for loop
//Check if all 3 cells have been hit/guessed correctly resulting in 'kill'    
    if (numOfHits == locationCells.length) {
      result = "kill";
    } // end if
//Display result for user (default miss or hit/kill depending on guess)    
    System.out.println(result);
//Return result back to calling method    
    return result;
  } // end method
} // close class