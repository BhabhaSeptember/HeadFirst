/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch02;

/**
 *
 * @author User
 */
public class StreamingSongTestDrive {
    
  public static void main(String[] args) {
//      ------ Page 42 Exercise --------
//The methods and fields have not been declared as static 
//So, we need to create an object instance of the class before accessing them
    StreamingSong song = new StreamingSong(); //added line of code
    song.artist = "The Beatles";
    song.title = "Oh Darling";
    song.play();
    song.printDetails();
  }
}
    

