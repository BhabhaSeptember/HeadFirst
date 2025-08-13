package ch10;

//Using Static Imports

import static java.lang.Math.*;
import static java.lang.System.out;

class WithStatic {
  public static void main(String[] args) {
//Using Math static imports may be a good choice because math methods are
//very clear to recognize
    out.println("sqrt " + sqrt(2.0));
    out.println("tan " + tan(60));
  }
}