package ch06;

import java.util.ArrayList;

public class Startup {
//Startup's instance variables    
//Create String type ArrayList to hold location of Startup cells    
  private ArrayList<String> locationCells; //an ArrayList of cell locations
  private String name; //the Startup's name

//Setter method to update Startup's location to random location,
// Location provided by GameHelpers placeStartup() method
  public void setLocationCells(ArrayList<String> loc) {
    locationCells = loc;
  }

//Basic setter method for Startup names  
  public void setName(String n) {
    name = n;
  }

//User input is of type String (e.g. A3 of grid)  
  public String checkYourself(String userInput) {
    String result = "miss";
//Check if user guess is in Arraylist by looking for its index in list
//i.e. what is the index of the first occurrence of the userInput value
//If not in the list, indexOf returns -1
    int index = locationCells.indexOf(userInput);
//If index is greater than or equal to zero (user guess is in list), remove it    
    if (index >= 0) {
      locationCells.remove(index);
//Check if list is empty, if it is, the Startup has been killed
//or else, it's just been hit
      if (locationCells.isEmpty()) {
        result = "kill";
//Tell the user when a Startup has been sunk        
        System.out.println("Ouch! You sunk " + name + "   : ( ");
      } else {
        result = "hit";
      } // end if
    } // end outer if
//Return miss, hit or kill    
    return result;
  } // end method
} // close class