/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author User
 */
public class PredictableSleep {
    
  public static void main (String[] args) throws InterruptedException {
      
    ExecutorService executor = Executors.newSingleThreadExecutor();
//Calling the method with the job inside it from inside this lambda expression    
    executor.execute(() -> sleepThenPrint());
    
    System.out.println("back in main");
    executor.shutdown();
  }

  private static void sleepThenPrint() {
    try {
        System.out.println("Put thread to sleep...");
//Calling sleep here will force the new thread to leave the 
//'currently running state' and main thread will execute       
        TimeUnit.SECONDS.sleep(2);  //pause for 2 seconds   
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("top o’ the stack");
  }
}

