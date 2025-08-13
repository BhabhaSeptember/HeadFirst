package ch11;

import java.util.*;

public class TestMap {
  public static void main(String[] args) {
//HashMap needs two type parameters for the key and value
//String = key && Integer = value
    Map<String, Integer> scores = new HashMap<>();

//put method, to add key-value pairs into the HashMap    
    scores.put("Kathy", 42);
    scores.put("Bert", 343);
    scores.put("Skyler", 420);

    System.out.println(scores);
//get() method takes key and returns value    
    System.out.println(scores.get("Bert"));
  }
}