package ch16_revisit;

import java.io.Serializable;

//In \src\main\java command prompt, run the following to get serialVersionUID:
// serialver -classpath . ch16.Dog
//Paste the result in the class as a static final long

public class Dog implements Serializable {

  static final long serialVersionUID =
          -6849794470754667710L;

  private String name;
  private int size;

    public static void main(String[] args) {
        System.out.println("Serial Version UID Example");
    }
  // method code here
}