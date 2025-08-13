package ch01;

class Shuffle1 {

    public static void main(String[] args) {

//SUMMARY:
//Step-by-step Execution:
//Start: x = 3
//
//x > 2 → print a
//
//x = 2
//
//print -
//
//x == 2 → print b c
//
//x = 1
//
//print -
//
//x == 1 → print d, then x = 0
//
//Now x = 0, so the while loop stops.
//This loop prints different letters and dashes based on the value of x. 
//The conditions trigger specific messages as x counts down from 3 to 0.
//Let me know if you want it rewritten in simpler or cleaner code
//
        int x = 3;
        while (x > 0) {

            if (x > 2) {
                System.out.print("a");
            }

            x = x - 1;
            System.out.print("-");

            if (x == 2) {
                System.out.print("b c");
            }

            x = x - 1;
            System.out.print("-");

            if (x == 1) {
                System.out.print("d");
                x = x - 1;
            }
        }
    }
}
