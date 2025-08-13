package ch10;

import java.util.Locale;

//FORMAT SPECIFIER SYNTAX:
//%[argument number][flags][width][.precision]type

//NOTE: "%, d" meaning...
// % - represents variable or the other arg in the method
// d - format that arg to decimal integer and
// , - also insert commas

public class TestFormats {
  public static void main(String[] args) {
    long myBillion = 1_000_000_000;
//first arg in 'format()' method is the instructions of how we wish to format
//the second arg in the method
    String s = String.format(Locale.US, "%,d", myBillion);
    System.out.println(s);
  }
}