package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunThreads {

  public static void main(String[] args) {
//Create an ExecutorService with a fixed-sized thread pool (2 jobs)      
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
//Lambda expression to represent the Runnable jobs instead of passing in 
//new instances of the Runnable class
    threadPool.execute(() -> runJob("Job 1"));
    threadPool.execute(() -> runJob("Job 2"));
    threadPool.shutdown();
  }

//The job for the threads is to run through the loop and print the 
//jobname and thread's name each time  
  public static void runJob(String jobName) {
    for (int i = 0; i < 25; i++) {
      String threadName = Thread.currentThread().getName();
      System.out.println(jobName + " is running on " + threadName);
    }
  }
}