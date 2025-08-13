package ch01;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FirstJavaClass {

    private static int x;

    public static void main(String[] args) {
//declare int variable called size and initialize with value of 27      
        int size = 27;

//declare String variable called name and initialize with value of Fido    
        String name = "Fido";

//creating a new object using Dog class called myDog
//we use the class constructor passing in above name & size variables as arguments
        Dog myDog = new Dog(name, size);

//variable x assigned the result of size variable (27) subtracted by 5    
        x = size - 5;

//if value of x is less than 15, the myDog object reference calls bark method
//bark method takes an argument of 8 (i.e. bark 8 times if x < 15 )
        if (x < 15) {
            myDog.bark(8);
        }
        if (x > 15) {
            myDog.bark(8);
        }

//while value of x is greater than 3, myDog object calls the play method 
//below results in infinite loop
//        while (x > 3) {
//            myDog.play();
//        }

//declare an int array called numList
//initialize array with values 2, 4, 6 & 8
        int[] numList = {2, 4, 6, 8};

//print String of Hello to console    
        System.out.print("Hello");

//print value of name field with label of Dog:    
        System.out.print("\nDog: " + name);

//declare a String variable called num
//initialize variable with String value of 8    
        String num = "8";

//converting num String variable to primitive int value
//assign that integer value to int variable of z
        int z = Integer.parseInt(num);

//try block attempts to call readTheFile method on given file name    
        try {
            readTheFile("myFile.txt");
        } //catch block catches the thrown exception from method if no such file is found    
        catch (FileNotFoundException ex) {
            System.out.print("\nFile not found.");
        }

    }

    private static void readTheFile(String s) throws FileNotFoundException {
        FileReader fr = new FileReader(s);
        System.out.println("\nFound file");
    }

}

class Dog {

    private final String name;
    private final int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark(int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(j + ". Barking, woof woof!");
        }

    }

    public void play() {
        System.out.println("Playing...");

    }
}
