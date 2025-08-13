/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch13;

/**
 *
 * @author User
 */

//Remember doLaundry() throws a ClothingException
//Here, main() method calls foo() method, and foo() calls doLaundry()
//Therefore doLaundry() runs and throws a ClothingException
//Then doLaundry() pops off the stack immediately and exception is thrown back 
//to foo()
//foo() has no try/catch block so it pops off stack and exception is thrown
//back to main() method. It also has no try/catch so exception is 
//thrown back to JVM which then shuts down the app

public class Washer {
     Laundry laundry = new Laundry();
  public void foo() throws ClothingException {   
    laundry.doLaundry();
  }
  public static void main (String[] args) throws ClothingException {
    Washer a = new Washer();
    a.foo();
  }
}
