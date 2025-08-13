package ch05;

class Output {
  public static void main(String[] args) {
    Output output = new Output();
    output.go();
  }

  void go() {
    int value = 7;
    for (int i = 1; i < 8; i++) { //i = 6
      value++; // value = 15
      if (i > 4) {
        System.out.print(++value + " "); // prints: 13 15
      }
      if (value > 14) {
        System.out.println(" i = " + i); //prints i = 6
        break;
      }
    }
  }
}


//----- Page 118 Exercise -----

//The ouput will be the following: 

//13 15 i = 6