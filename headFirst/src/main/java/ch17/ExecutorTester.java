/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author User
 */
//ExecutorService is in interface in java.util.concurrent whose implementations
//will execute jobs(Runnables) behind the scenes i.e. create, reuse and
//kill threads in order to run the jobs
//Static factory methods can be used instead of constructors
public class ExecutorTester {

    public static void main(String[] args) {
        Runnable job = new MyRunnable();

//Use method on Executors class to create an ExecutorService instead of 
//creating a Thread instance
//Here we start a single job so we create a single thread executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

// Tell ExecutorService to run the job. It will take care of starting a new
//thread for the job if it needs to
        executor.execute(job);

        System.out.println(Thread.currentThread().getName()
                + ": back in main");
        Thread.dumpStack();
//Shut down the ExecutorService otherwise it will hang waiting for more jobs    
        executor.shutdown();
    }
}
