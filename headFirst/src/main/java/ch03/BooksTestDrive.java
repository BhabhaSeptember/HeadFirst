/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch03;

/**
 *
 * @author User
 */
//SUMMARY
//The program creates an array of Books objects, assigns each book a title and 
//author, and then prints out the details for each one
//1) Array Declaration
//This creates an array that can hold 3 references to Books objects.
//Initially, all elements are null
//
//2) Object Creation
//Instantiates actual Books objects at each index.
//Now the array elements point to valid Books objects
//
//3) Assigning Values
//
//4) Looping to Print Details
//Uses a while loop to print the title and author of each book.

public class BooksTestDrive {
    public static void main(String[] args) {
    Books[] myBooks = new Books[3];
    
    int x = 0;
    
//Previously the reference variables in the array were null 
//They were not referencing any object so no access to class instance variables
    myBooks[0] = new Books(); //added line of code
    myBooks[1] = new Books(); //added line of code
    myBooks[2] = new Books(); //added line of code
    
    myBooks[0].title = "The Grapes of Java";
    myBooks[1].title = "The Java Gatsby";
    myBooks[2].title = "The Java Cookbook";
    
    myBooks[0].author = "bob";
    myBooks[1].author = "sue";
    myBooks[2].author = "ian";

    while (x < 3) {
      System.out.print(myBooks[x].title);
      System.out.print(" by ");
      System.out.println(myBooks[x].author);
      x = x + 1;
    }
  }
}
