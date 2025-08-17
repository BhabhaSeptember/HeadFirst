package ch18;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//Compare-And-Swap using compareAndSet() method

public class RyanAndMonicaAtomicTest {
  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 100; i++) {
      BankAccountWithAtomic account = new BankAccountWithAtomic();
      RyanAndMonicaAtomicJob ryan = new RyanAndMonicaAtomicJob("Ryan", account, 50);
      RyanAndMonicaAtomicJob monica = new RyanAndMonicaAtomicJob("Monica", account, 100);
      ExecutorService executor = Executors.newFixedThreadPool(2);
      executor.execute(ryan);
      executor.execute(monica);
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.MINUTES);
      System.out.println("---");
    }
  }
}

class RyanAndMonicaAtomicJob implements Runnable {
  private final String name;
  private final BankAccountWithAtomic account;
  private final int amountToSpend;

  RyanAndMonicaAtomicJob(String name, BankAccountWithAtomic account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  @Override
  public void run() {
    goShopping(amountToSpend);
  }

  private void goShopping(int amount) {
    System.out.println(name + " is about to spend");
    account.spend(name, amount);
    System.out.println(name + " finishes spending");
  }
}

//
class BankAccountWithAtomic {
  private final AtomicInteger balance = new AtomicInteger(100);

  public void spend(String name, int amount) {     
    int initialBalance = balance.get();
    if (initialBalance >= amount) {
//boolean success = True if the balance was updated to the new value, if false,
//we decide what to do next
//1st arg : expectedValue = the value we think the balance is
//2nd arg : newValue = the value we want the balance to have
//THEREFORE, if initialBalance(or the read balance) is not the same as the 
//actual balance then it will be false, and balance wont be changed to the 
//new value after wanting to spend...
      boolean success = balance.compareAndSet(initialBalance, initialBalance - amount);
      if (!success) {
        System.out.println("Sorry " + name + ", you haven't spent the money.");
      }
    } else {
      System.out.println("Sorry, not enough for " + name);
    }
  }
}