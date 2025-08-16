/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author User
 */
//NOTES:
//CountDownLatch is a barrier synchronizer. Barriers are mechanisms to
//allow threads to co-ordinate with each other
//Other examples include CyclicBarrier and Phaser
public class PredictableLatch {
//We can make threads count down when significant events have occurred
//We set a number to count down from then any thread can tell the latch to
//count down when a relevant event has happened

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
//Create a new CountDownLatch object which lets us wait for a signal
//Here we wait for one event (main thread printing a message) so set to '1'
        CountDownLatch latch = new CountDownLatch(1);
//Pass the CountDownLatch to the job that's going to run on the new thread    
        executor.execute(() -> waitForLatchThenPrint(latch));
        System.out.println("back in main");
//Tell latch to count down when the main method has printed its message    
        latch.countDown();
        System.out.println("Latch Counting Down...");
        executor.shutdown();
    }

//The method with the job that will be run on the new thread  
    private static void waitForLatchThenPrint(CountDownLatch latch) {
        try {
//This new thread will await for the main thread to print out its message
//Therefore this new thread will remain in a temporarily non-runnable state
//while it waits
System.out.println("Latch Awaiting...");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("top o’ the stack");
    }
}
