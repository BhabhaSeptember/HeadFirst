package ch16_revisit;

import java.io.*; //for FileWriter class

class WriteAFile {
  public static void main(String[] args) {
    try {
//Create 'Foo.txt' file to write to if it doesnt already exist        
      FileWriter writer = new FileWriter("Foo.txt");  
//write() method takes string      
      writer.write("hello foo!");     
      writer.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}