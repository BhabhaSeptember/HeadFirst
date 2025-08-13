package ch16_revisit;

import java.io.*;

class ReadAFile {
  public static void main(String[] args) {
    try {
      File myFile = new File("MyText.txt");
//FileReader is a connection stream      
      FileReader fileReader = new FileReader(myFile);

      BufferedReader reader = new BufferedReader(fileReader);

      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}