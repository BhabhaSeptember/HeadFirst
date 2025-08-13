package ch16_revisit;

import java.io.*;

class Chat implements Serializable {
//Transient instance variables are those that cant or shouldnt be saved    
  transient String currentID;

//Here, the userName would be savable/serializable  
  String userName;

  // more code
}