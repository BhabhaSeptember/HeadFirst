package ch17;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

//ExecutorService.shutdown() : All Threads that are currently running jobs are 
//allowed to finish those jobs, any jobs waiting in the queue will also be
//finished off but ExecutorService will reject any new jobs
//Can use 'awaitTermination' if we need the code to wait til all is finished by
//giving it a max amount of time to wait. Either ExecutorService finishes first
//or awaitTermination closes all processes
//ExecutorService.shutdownNow() : With this, ExecutorService tries to stop any
//Threads that are currently running, it wont run any waiting jobs and will
//reject any new threads/jobs 
public class ClosingTime {
    
  public static void main(String[] args) throws InterruptedException {
//Create a thread pool with 2 threads      
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    
//Start two jobs using classes that implement Runnable    
    threadPool.execute(new LongJob("Long Job"));
    threadPool.execute(new ShortJob("Short Job"));
    
//Ask ExecutorService to shutdown. Calling the execute() method after this will
//result in RejectedExecutionException but all running jobs and waiting jobs
//will be executed
    threadPool.shutdown();

    try {
//Wait up to 5 seconds for ExecutorService to finish all processes
//If method hits timeout before everything is finished, it returns FALSE
      boolean finished = threadPool.awaitTermination(5, TimeUnit.SECONDS);
      System.out.println("Finished? " + finished);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//Tell ExecutorService to stop everything. If everything was already shut down
//this code wont do anything
    threadPool.shutdownNow();
  }
}

//Class with the jobs to run for new created threads
abstract class NamedJob implements Runnable {
  protected String jobName;

  NamedJob(String jobName) {
    this.jobName = jobName;
  }
}

class ShortJob extends NamedJob {
  ShortJob(String jobName) {
    super(jobName);
  }

  @Override
  public void run() {
    System.out.println(jobName);
  }
}

class LongJob extends NamedJob {
  LongJob(String jobName) {
    super(jobName);
  }

  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(3);
      System.out.println(jobName);
    } catch (InterruptedException e) {
      System.out.println("Job interrupted: " + jobName);
      e.printStackTrace();
    }
  }
}
