package ch12_revisit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LimitWithStream {

  public static void main(String[] args) {
    streamExamples();
    
    limitWithCountTerminal();
    
    limitWithCollect();
    
    limitAsStream();
    
    chainedOperations();
    
    sortingCaseInsensitive();
    
//    noReusing(); //throws Exception
    
    printCollectionAfterChanges();
  }

  static void streamExamples() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
//call the stream() method on strings List to get a Stream of the Strings    
    Stream<String> stream = strings.stream();
//limit method sets the max number of results returned to 4
//the limit method returns another Stream of Strings which we assign to,
//another variable
    Stream<String> limit = stream.limit(4);
    System.out.println("limit = " + limit);
  }

  static void limitWithCountTerminal() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

    Stream<String> stream = strings.stream();
    Stream<String> limit = stream.limit(4);
//Call the 'count()' terminal operator and store output in variable 'result'    
    long result = limit.count();
    System.out.println("result = " + result);
  }

  static void limitWithCollect() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

    Stream<String> stream = strings.stream();
    Stream<String> limit = stream.limit(4);
//toList Collector will output results as a List    
//The stream contained Strings, so output object will contain Strings 
//'collect()' is a terminal operation that collects output into some Object
//Collectors is a class that contains methods to return 
//common,Collector implementations
//'toList()' method returns Collector that outputs results of the stream,
//into a List
    List<String> result = limit.collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  static void limitAsStream() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

//Chaining stream operations/creating a stream pipeline    
    List<String> result = strings.stream()//stream from source collection
                                 .limit(3)//intermediate operation
                                 .collect(Collectors.toList());//terminal op
    System.out.println("result = " + result);
  }

  static void chainedOperations() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

//elements in the stream(not the source) are sorted using natural order     
    List<String> result = strings.stream() 
                                 .sorted()
                                 .limit(4)
                                 .collect(Collectors.toList());
    System.out.println("result = " + result);

    List<String> result2 = strings.stream()
                                  .sorted()
                                  .skip(3) //skips over first 3 elements
                                  .limit(4)
                                  .collect(Collectors.toList());
    System.out.println("result = " + result2);
  }

  static void sortingCaseInsensitive() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

//Lambda expression represents Comparator
//compareToIgnoreCase() is String class method and compares String,
//with another String but ignores upper&lowercase
    List<String> result = strings.stream()
                                 .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                                 .limit(4)
                                 .collect(Collectors.toList());
    System.out.println("result = " + result);
  }
  
  
//NOTES: " .collect(Collectors.toList()); " 
//collect() = Terminal operation. Performs all intermediate operations,
//collects & returns results according to instructions passed into it,
//Collectors.toList() = collect method takes a Collector with instructions,
//on how to put result together. Here it puts result into a List
//Collectors = a class with static methods that provide different,
//implementations of Collector  

  static void filtering() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

    List<String> result = strings.stream()
                                 .filter(s -> s.length() < 4)
                                 .collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  
  static void printCollectionAfterChanges() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

//Stream operations do not change the original source    
    List<String> result = strings.stream()
                                 .limit(4)
                                 .collect(Collectors.toList());
    System.out.println("strings = " + strings);
    System.out.println("result = " + result);
  }


//We cannot reuse Streams  
  static void noReusing() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

    Stream<String> limit = strings.stream()
                                  .limit(4);
    
    List<String> result = limit.collect(Collectors.toList());
    
//below results in Exception being thrown:
//Exception in thread "main" java.lang.IllegalStateException: 
//stream has already been operated upon or closed
    List<String> result2 = limit.collect(Collectors.toList());
  }

}

