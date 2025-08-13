package ch05;

class MixFor5 {

    public static void main(String[] args) {
        int x = 0; //x = 36
        int y = 30; //y = 6
        for (int outer = 0; outer < 3; outer++) { //outer = 3
            for (int inner = 4; inner > 1; inner--) { //inner = 1
                // candidate code goes here
                x = x + 0; 
                // end candidate code

                y = y - 2; 
                if (x == 6) {
                    break;
                }//end of if statement
                x = x + 3; 
            }//end of inner loop
            y = y - 2; 
        }//end of outer loop
        System.out.println(x + " " + y);
    }
}


//----- Page 121 Exercise -----

//CANDIDATE        ----->   OUTPUT
//x = x + 3;                 54 6
//x = x + 6;                 60 10        
//x = x + 2;                 45 6
//x++;                       36 6
//x--;                       18 6
//x = x + 0;                  6 14
