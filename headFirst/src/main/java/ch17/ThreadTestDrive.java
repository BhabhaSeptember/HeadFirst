/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17;

/**
 *
 * @author User
 */

public class ThreadTestDrive {

    public static void main(String[] args) {
//Thread instance/object has been created        
        Thread myThread = new Thread(()
                -> System.out.println("top o’ the stack"));
//thread of execution begins i.e. Thread is now Runnable but waits for the 
//thread schedular before it becomes a Running thread
        myThread.start();
        System.out.println("back in main");
    }
}
