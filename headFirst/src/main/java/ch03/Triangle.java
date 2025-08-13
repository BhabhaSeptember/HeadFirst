package ch03;

//class Triangle {
//
//    double area;
//    int height;
//    int length;
//
//    public static void main(String[] args) {
//        int x = 0;
//        Triangle[] ta = new Triangle[4];
//
//        while (x < 4) {
//            ta[x] = new Triangle();
//            ta[x].height = (x + 1) * 2;
//            ta[x].length = x + 4;
//            ta[x].setArea();
//            System.out.print("triangle " + x + ", area");
//            System.out.println(" = " + ta[x].area);
//            x = x + 1;
//        }//end of while loop
//
//        int y = x;
//        x = 27;
//        Triangle t5 = ta[2];
//        ta[2].area = 343;
//        System.out.print("y = " + y);
//        System.out.println(", t5 area = " + t5.area);
//    }
//
//    void setArea() {
//        area = (height * length) / 2;
//    }
//}

//========================================================================

//----- Page 65 Exercise -----
//SUMMARY: 
//1) Class Definition:
//A Triangle class is defined with:
//Fields: area (double), height, and length (ints)
//A method setArea() that computes the area
//
//2)A Triangle array ta of size 4 is created.
//A while loop populates each element in ta with a new Triangle, 
//sets its height and length based on the loop index, 
//calculates its area, and prints the area.
//
//3) After the loop:
//y is assigned the value of x (which is 4).
//x is then overwritten with 27 (unused afterward).
//t5 is set to refer to the same object as ta[2].
//The area of ta[2] is set to 343.
//Since t5 and ta[2] refer to the same object, printing t5.area also shows 343.

class Triangle {
  double area;
  int height;
  int length;

  public static void main(String[] args) {
    int x = 0;
    Triangle[] ta = new Triangle[4];
    while ( x < 4 ) {
    ta[x] = new Triangle();
      ta[x].height = (x + 1) * 2;
      ta[x].length = x + 4;
      ta[x].setArea();
      System.out.print("triangle " + x + ", area");
      System.out.println(" = " + ta[x].area);
      x = x + 1;
    }
    int y = x;
    x = 27;
    Triangle t5 = ta[2];
    ta[2].area = 343;
    System.out.print("y = " + y);
    System.out.println(", t5 area = " + t5.area);
  }
  void setArea() {
    area = (height * length) / 2;
  }
}


