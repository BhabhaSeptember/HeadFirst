package ch16_revisit;

import java.io.*; //for Serializable interface

//Serializable is a marker/tag interface that declares a class as being savable/
//serializable. The interface has no methods
public class Square implements Serializable {
    
//The instance variables/state of object to be saved    
  private int width;
  private int height;

  public Square(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public static void main(String[] args) {
    Square mySquare = new Square(50, 20);

    try {
//Connection stream that connects to a file named 'foo.ser' if it exists
//otherwise it is created automatically (writes object in bytes)
      FileOutputStream fs = new FileOutputStream("foo.ser");
//Chain ObjectOutputStream to connection stream      
      ObjectOutputStream os = new ObjectOutputStream(fs);
//Argument to writeObject method must implement Serializable or it will fail 
//at runtime (object is written)
      os.writeObject(mySquare);
      os.close();
    } catch (Exception ex) { //I/O operations can throw exceptions
      ex.printStackTrace();
    }
  }
}

