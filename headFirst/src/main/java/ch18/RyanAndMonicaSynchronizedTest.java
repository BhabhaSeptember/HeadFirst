package ch18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Synchronized keyword means a thread needs a key to access the code
//It can be used on a method or with an object to lock an object so that 
//only one thread can access an object at a time
public class RyanAndMonicaSynchronizedTest {
  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      BankAccountSynchronized account = new BankAccountSynchronized();
      RyanAndMonicaSynchronizedJob ryan = new RyanAndMonicaSynchronizedJob("Ryan", account, 50);
      RyanAndMonicaSynchronizedJob monica = new RyanAndMonicaSynchronizedJob("Monica", account, 100);
      ExecutorService executor = Executors.newFixedThreadPool(2);
      executor.execute(ryan);
      executor.execute(monica);
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.MINUTES);
      System.out.println("---");
    }
  }
}

class RyanAndMonicaSynchronizedJob implements Runnable {
  private final String name;
  private final BankAccountSynchronized account;
  private final int amountToSpend;

  RyanAndMonicaSynchronizedJob(String name, BankAccountSynchronized account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  @Override
  public void run() {
    goShopping(amountToSpend);
  }

  private void goShopping(int amount) {
//Putting a lock on the BankAccount inside the method that does the 
//banking transaction
//Therefore one thread will get the objects lock key and get to complete the
//synchronized block even if taken out of running state by thread schedular
//So another thread wont have access to this method until the thread with the
//key has completed the whole transaction
    synchronized (account) {
      if (account.getBalance() >= amount) {
        System.out.println(name + " is about to spend");
        account.spend(amount);
        System.out.println(name + " finishes spending");
      } else {
        System.out.println("Sorry, not enough for " + name);
      }
    }
  }
}

class BankAccountSynchronized {
  private int balance = 100;

  public int getBalance() {
    return balance;
  }

  public void spend(int amount) {
    balance = balance - amount;
    if (balance < 0) {
      System.out.println("Overdrawn!");
    }
  }
}
