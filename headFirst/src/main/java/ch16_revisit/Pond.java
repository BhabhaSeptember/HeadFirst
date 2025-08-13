package ch16_revisit;

import java.io.*;

public class Pond implements Serializable {
  private Duck duck = new Duck();

  public static void main(String[] args) {
    Pond myPond = new Pond();
    try {
      FileOutputStream fs = new FileOutputStream("Pond.ser");
      ObjectOutputStream os = new ObjectOutputStream(fs);
      
//Serializing myPond object automatically serializes the Duck object instance
//variable. But Duck object does not implement Serializable so operation fails
//with: java.io.NotSerializableException: ch16.Duck
      os.writeObject(myPond);
      os.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

