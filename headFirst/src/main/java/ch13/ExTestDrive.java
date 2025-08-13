package ch13;

class MyEx extends Exception { }

//SUMMARY:
//The program: Reads a command-line argument (args[0]) into a variable called 
//test. (e.g. args[0] is yes or no)
//Prints characters to show the flow of execution:
//"t" is always printed first.
//Calls the method doRisky(test):
//Prints "h" inside doRisky.
//If test.equals("yes"), it throws a custom exception MyEx.
//If not, it prints "r".
//If MyEx is thrown, it catches it and prints "a".
//Whether there was an exception or not, the finally block runs and prints "w".
//Finally, it prints "s" on a new line
public class ExTestDrive {
  public static void main(String[] args) {
    String test = args[0];
    try {
      System.out.print("t");
      doRisky(test);
      System.out.print("o");
    } catch (MyEx e) {
      System.out.print("a");
    } finally {
      System.out.print("w");
    }
    System.out.println("s");
  }

  static void doRisky(String t) throws MyEx {
    System.out.print("h");

    if ("yes".equals(t)) {
      throw new MyEx();
    }

    System.out.print("r");
  }
}
