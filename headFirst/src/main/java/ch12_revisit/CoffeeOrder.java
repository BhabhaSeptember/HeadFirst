package ch12_revisit;

import java.util.List;
import java.util.stream.Collectors;

public class CoffeeOrder {
  public static void main(String[] args) {
      
//an immutable List containing Strings of coffee names is created using, 
//the 'List.of()' factory method      
    List<String> coffees = List.of("Cappuccino",
            "Americano", "Espresso", "Cortado", "Mocha",
            "Cappuccino", "Flat White", "Latte");

//A stream is created from the list an several operations are applied:
//filter() method contains a lambda expression that will keep elements,
//whose names end with an "o"
//sorted() method will order the filtered names in alphabetical order
//distinct() method removes duplicates from the sorted list
//collect() is a terminal operation that uses Collector class toList() method,
//to produce an output of List items
    List<String> coffeesEndingInO = coffees.stream()
                                           .filter(s -> s.endsWith("o"))
                                           .sorted()
                                           .distinct()
                                           .collect(Collectors.toList());
    
//Print the result of the stream pipeline    
    System.out.println(coffeesEndingInO);
  }
}
