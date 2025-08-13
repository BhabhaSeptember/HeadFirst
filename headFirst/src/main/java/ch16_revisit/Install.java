package ch16_revisit;

import java.io.*;
import java.nio.file.*;

//Path interface: For Path object to locate directories/files. Path object
//represents location (name & path) of file or directory on disk
//Paths class: e.g. use Paths.get() method to make the Path object we need
//when we use methods in the Files class
//Files class: Contains static methods who do all the work we'd want e.g.
//making new Readers & Writers, creating, modifying, searching through
//directories and files on file systems
public class Install {
  public static void main(String[] args) {
    try {
//Creating Path object with name & location of files & directories        
      Path myPath = Paths.get("MyApp");
      Path myPath2 = Paths.get("MyApp", "media");
      Path myPath3 = Paths.get("MyApp", "source");
      Path mySource = Paths.get("MyApp.class");
      Path myMedia = Paths.get("MyMedia.jpeg");

//Creating 3 new directories      
      Files.createDirectory(myPath); //  MyApp
      Files.createDirectory(myPath2); //  MyApp/media
      Files.createDirectory(myPath3); //  MyApp/source
//Move the two files into their new directories      
//1)Move MyApp.class file into MyApp/source directory
      Files.move(mySource, myPath3.resolve(mySource.getFileName()));
//2)Move MyMedia.jpeg into MyApp/media  directory    
      Files.move(myMedia, myPath2.resolve(myMedia.getFileName()));
    } catch (IOException e) {
      System.out.println("Got an NIO Exception " + e.getMessage());
    }
  }
}