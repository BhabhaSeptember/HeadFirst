/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch04;

/**
 *
 * @author User
 */
public class GoodDogTestDrive {
    
    public static void main(String[] args) {
    GoodDog one = new GoodDog();
//Using the public setter method to set the size instance variable    
    one.setSize(70);
    GoodDog two = new GoodDog();
    two.setSize(8);
    
//Using the public getter method to retrieve the value of instance variable    
    System.out.println("Dog one: " + one.getSize());
    System.out.println("Dog two: " + two.getSize());
    one.bark();
    two.bark();
  }
    
}
