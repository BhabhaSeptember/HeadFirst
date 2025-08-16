package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Runnable interface is in java.lang package so doesnt need to be imported
public class MyRunnable implements Runnable {

//Runnable interface has one method 'run()'
//The code which a new thread must run will be put here and the method goes
//at the bottom of the new call stack    
    @Override
  public void run() {
    go();
  }

  public void go() {
    doMore();
  }

  public void doMore() {
    System.out.println(Thread.currentThread().getName() + ": top o’ the stack");
//dumpStack method will output the current call stack like an Exception stack
//trace. It shows the current stack and should only be used for debugging
    Thread.dumpStack();
  }
}

//=============================================================================

////HOW NOT TO RUN THE RUNNABLE
////This code below will not work as we expect it to because the run() method is
////sitting in the main method, so it becomes part of the main method call stack
////instead of its own new call stack
//class RunTester {
//  public static void main(String[] args) {
//    MyRunnable runnable = new MyRunnable();
//    runnable.run();
//
//    System.out.println(Thread.currentThread().getName() +
//                       ": back in main");
//    Thread.dumpStack();
//  }
//}
//=============================================================================
////AN OLD APPROACH TO LAUNCHING A NEW THREAD
//class ThreadTester {
//  public static void main(String[] args) {
//    Runnable threadJob = new MyRunnable();
////Pass the new Runnable instance into the new Thread constructor and it will
////tell the thread which job to run i.e. the Runnable's run() method will be 
////the first method that the new thread will run
//    Thread myThread = new Thread(threadJob);
//
////In order to get a new thread of execution we must call the start() method
////on the Thread instance otherwise the Thread instance remains an object
////Now we will have two independent call stacks
//    myThread.start();
//
//    System.out.println(Thread.currentThread().getName() +
//                       ": back in main");
//    Thread.dumpStack();
//  }
//}
//=============================================================================

////ExecutorService is in interface in java.util.concurrent whose implementations
////will execute jobs(Runnables) behind the scenes i.e. create, reuse and
////kill threads in order to run the jobs
////Static factory methods can be used instead of constructors
//class ExecutorTester {
//  public static void main(String[] args) {
//    Runnable job = new MyRunnable();
//    
////Use method on Executors class to create an ExecutorService instead of 
////creating a Thread instance
////Here we start a single job so we create a single thread executor
//    ExecutorService executor = Executors.newSingleThreadExecutor();
//    
//// Tell ExecutorService to run the job. It will take care of starting a new
////thread for the job if it needs to
//    executor.execute(job);
//
//    System.out.println(Thread.currentThread().getName() +
//                       ": back in main");
//    Thread.dumpStack();
////Shut down the ExecutorService otherwise it will hang waiting for more jobs    
//    executor.shutdown();
//  }
//}

//=============================================================================

class StackUtils {
  static String getCurrentStack() {
    StringBuffer stack = new StringBuffer();
    StackWalker.getInstance()
               .forEach(stackFrame -> stack.append(stackFrame.toString()).append("\n"));
    return stack.toString();
  }
}
