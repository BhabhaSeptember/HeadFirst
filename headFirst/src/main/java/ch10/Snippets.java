package ch10;

import java.util.ArrayList;
import java.util.Locale;

public class Snippets {

    void mathMethods() {
//Math methods do not use any instance variable values, they are static
//Infact, Math clas constructor is marked as private,
//therefore we cannot instantiate a Math class object
        long x = Math.round(42.2);
        int y = Math.min(56, 12);
        int z = Math.abs(-343);
    }

//STATIC METHOD  
//No instance variable required, the method behaviour does not change,
//with instance variable state  
//We use class name to access static method instead of reference variable
    public static int min(int a, int b) {
        //returns the smallest of a and b
        return Math.min(a, b);
    }

    void rounding() {
        int x = Math.round(-24.8f);  // returns -25
        int y = Math.round(24.45f);  // returns 24
        long z = Math.round(24.45);  // returns 24L
    }

//AUTOBOXING  
    void wrapInt() {
//declare and initialize an int variable      
        int x = 32;
//make an ArrayList of type Integer     
        ArrayList<Integer> list = new ArrayList<Integer>();
//compiler autoboxes the int to its object form for us    
        list.add(x);
//compiler auto-unboxes the primitive from the object for us    
        int num = list.get(0);
    }

    void wrappers() {
        boolean b = true;
        Boolean bool = b;
        char c = 'a';
        Character chr = c;
        byte bt = 0;
        Byte bte = bt;
        short s = 1;
        Short sht = s;
        int i = 2;
        Integer intr = i;
        long l = 3;
        Long lng = l;
        float f = 4;
        Float flt = f;
        double d = 5;
        Double dbl = d;
    }

    public void autoboxing() {
        int x = 32;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(x);

        int num = list.get(0);
    }

//Wrappers have static utility methods such as parse methods
//parse methods take a String and return the primitive value type 
    static void parse() {
        String s = "2"; //string
        int x = Integer.parseInt(s);

        double d = Double.parseDouble("420.24"); //string

        boolean b = Boolean.parseBoolean("True"); //string
    }

    static void badParse() {
//'two' cannot be parsed to a number format so the code will compile but,
//at runtime, it will cause a NumberFormat Exception
        String t = "two";
        int y = Integer.parseInt(t);
        System.out.println(y);
    }

//Turning primitive numbers into Strings  
//Option 1: 
//NOTE: '+' is an overloaded operator as a String concatenator so,
//adding anything to a string with the '+' will stringify it  
    void doubleToString1() {
        double d = 42.5;
//easist option is to concatenate number to an existing String    
        String doubleString = "" + d;
    }

//Option 2: 
//Use the static 'toString' method in class   
    void doubleToString2() {
        double d = 42.5;
        String doubleString = Double.toString(d);
    }

//Option 3: 
//Use Strings overloaded, static method 'valueOf' to get the String value
//of the arg  
    void doubleToString3() {
        double d = 42.5;
        String doubleString = String.valueOf(d);
    }

//NUMBER FORMATTING
//NOTES:   
// %,d  means “insert commas and format the number as a decimal integer.”
// 
// %.2f means “format the number as a floating point with a 
//  precision of two decimal places.”
// 
// %,.2f  means “insert commas and format the number as a floating point 
//  with a precision of two decimal places.”
//First arg in format() method is called the format String,
//it can include characters we literally want printed in final string
//% sign represents the other arg in method  
    static void format() {
        String s = String.format("I have %.2f, bugs to fix.", 476578.09876);
        System.out.println(s);
    }

    static void formatWithCommas() {
        String s2 = String.format("I have %,.2f, bugs to fix.", 476578.09876);
        System.out.println(s2);

        System.out.println(String.format("%,6.1f", 42.000));
    }

    static void formatDecimal() {
//decimal specifier type is only compatible with: int, byte, short, char
//(and their wrapper types)
        System.out.println(String.format("%d", 42));
    }

    static void formatFloat() {
//floating point specifier type, only accepts args which are:
//floats or doubles (incl primitive & wrapper objects) 
        System.out.println(String.format("%.3f", 42.000000));
    }

    static void formatHex() {
//hexadecimal specifier type accepts args which are:
//byte, short, int, long (incl primitive & wrapper objects)
        System.out.println(String.format("%x", 42));//output: 2a
    }

    static void formatChar() {
//character specifier type accepts arge which are:
//byte, short, char, int (incl primitive & wrapper objects)
        System.out.println(String.format("%c", 42)); //output: *
    }

    static void formatTwo() {
        int one = 20456654;
        double two = 100567890.248907;
        String s = String.format("The rank is %,d out of %,.2f", one, two);

        System.out.println(s);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        formatChar();

        parse();

        format();
        formatWithCommas();

        formatDecimal();
        formatFloat();
        
        formatTwo();

    }
}
