package ch17;

//Thread schedular is unpredictable or 'not deterministic'
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTestDrive {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newSingleThreadExecutor();
//Runnable is a Functional Interface that can be represented as a lambda
//expression
    executor.execute(() -> System.out.println("top o’ the stack"));
    System.out.println("back in main");

    executor.shutdown();
  }
}