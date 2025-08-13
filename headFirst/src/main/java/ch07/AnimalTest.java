/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch07;

/**
 *
 * @author User
 */
public class AnimalTest {

    public static void main(String[] args) {
        
        Wolf w = new Wolf();

//When we call a method, JVM invokes the lowest in the inheritance tree

        w.makeNoise(); //invokes the method version in Wolf class
        
        w.roam(); //invokes the method version in Canine class
        
        w.eat(); //invokes method version in Wolf class
        
        w.sleep(); //invokes method in Animal class
    }

}
