package ch18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//NOTE: 
//This class illustrates what can happen with multiple threads accessing a
//multi-step block of code: 1) reading a value and 2)incrementing that value
//Sometimes a thread can be placed out of running while it just read a value
//before updating it, then another thread will read the same value and 
//incrememnt it. Once the other thread(who stopped at reading) comes back to
//running, it retains the value it read instead of the new value so we lose
//updates that were made by the other threads
//
//
//OPTION 2: Instead of using synchronization which can result in deadlocks or
//performance issues,  we can use Atomic Variables if shared data is of type:
//int, long or boolean
//These classes provide methods that are atomic e.g. AtomicInteger, AtomicLong,
//AtomicBoolean, AtomicReference

public class LostUpdate {
  public static void main(String[] args) throws InterruptedException {
//Create a thread pool to run jobs      
    ExecutorService pool = Executors.newFixedThreadPool(6);
//    Balance balance = new Balance(); //example1 - synchronized 
    AtomicBalance balance = new AtomicBalance();//example2 - atomic variable

//Run 1000 attempts to update the balance on different threads
    for (int i = 0; i < 1000; i++) {
      pool.execute(() -> balance.increment());
    }
    pool.shutdown();
//Make sure the pool has finished running all the updates before printing the 
//final balance. In theory there should be 1000. If it's less then updates have
//been lost
    if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
      System.out.println("balance = " + balance.balance);
    }
  }
}

class Balance {
  int balance = 0;

//Add synchronized here to see it work properly. i.e. keep the steps of the 
//method as one atomic unit (read, incremement & update)
  
//  public synchronized void increment() { //example1 - method signature
  public void increment() { //example2 - method signature
    balance++;
  }
}


class AtomicBalance {
//Use AtomicInteger instead of int value    
  AtomicInteger balance = new AtomicInteger(0);

//No need to add 'synchronized' when using atomic operations  
  public void increment() {
//incrementAndGet() method atomically adds one to the value i.e.even if used by
//multiple threads, it will safely increase value by one in a single operation
//and return the new, updated value. In this case we dont use the returned value
    balance.incrementAndGet();
  }
}

