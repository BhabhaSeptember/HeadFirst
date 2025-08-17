package ch18;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;
import static java.time.format.FormatStyle.MEDIUM;

//Running this class can sometimes result in ConcurrentModificationException
//This exception is thrown by the reading thread when the List it is reading is 
//changed while the thread is reading it
//
//Solution can be to use CopyOnWriteArrayList in cases where a List is being read
//a lot more but not changed very often
public class ConcurrentReaders {
    
  public static void main(String[] args) {
//Store Chat objects in ArrayList which is not thread safe      
//    List<Chat> chatHistory = new ArrayList<>(); //example1
//CopyOnWriteArrayList implements List interface so we can use it as a drop-in
//replacement for any List
    List<Chat> chatHistory = new CopyOnWriteArrayList<>(); //example2
    
    ExecutorService executor = Executors.newFixedThreadPool(3);
//Loop the writing thread that adds to the List and 2 threads that read from the List    
    for (int i = 0; i < 5; i++) {
      executor.execute(() -> chatHistory.add(new Chat("Hi there!")));
      executor.execute(() -> System.out.println(chatHistory));
      executor.execute(() -> System.out.println(chatHistory));
    }
    executor.shutdown();
  }
}

//Instances of Chat class are immutable
final class Chat {
//NOTE: Making an object field 'final' doesnt guarentee the data inside wont change,
//it's only the reference that wont change but String and LocalDateTime are immutable
//so this is safe    
  private final String message;
  private final LocalDateTime timestamp;

  public Chat(String message) {
    this.message = message;
    timestamp = LocalDateTime.now();
  }

  @Override
  public String toString() {
    String time = timestamp.format(ofLocalizedTime(MEDIUM));
    return time + " " + message;
  }
}
