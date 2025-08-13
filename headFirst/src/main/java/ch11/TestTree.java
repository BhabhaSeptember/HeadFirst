package ch11;

import java.util.*;

public class TestTree {
  public static void main(String[] args) {
    new TestTree().go();
  }

  public void go() {
    Book b1 = new Book("How Cats Work");
    Book b2 = new Book("Remix your Body");
    Book b3 = new Book("Finding Emo");

    Set<Book> tree = new TreeSet<>();
    tree.add(b1);
    tree.add(b2);
    tree.add(b3);
    System.out.println(tree);
  }
}

class Book implements Comparable<Book> {
  String title;
  public Book(String t) {
    title = t;
  }

  @Override
  public int compareTo(Book other) {
    return title.compareTo(other.title);
  }

  @Override
  public String toString() {
    return "Book{" +
            "title='" + title + '\'' +
            '}';
  }
}

//----- Page 353 Exercise -----

// 1. What is the result when you compile this code?
//
//ANSWER:
//The code will compile


// 2. If it compiles, what is the result when you run the TestTree class?
//
//ANSWER: 
//At runtime there will be an exception: Exception in thread "main" 
//java.lang.ClassCastException: class ch11.Book cannot be cast to 
//class java.lang.Comparable 


// 3. If there is a problem (either compile-time or runtime) with this code,
//how would you fix it?
//
//ANSWER:
//The Book class must implement comparable or we must pass a Comparator,
//to the TreeSet constructor