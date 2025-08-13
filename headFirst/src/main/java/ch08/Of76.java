package ch08;

public class Of76 extends Clowns {
    
  public static void main(String[] args) {
    Nose[] i = new Nose[3];
    i[0] = new Acts();
    i[1] = new Clowns();
    i[2] = new Of76();
    for (int x = 0; x < 3; x++) {
      System.out.println(i[x].iMethod()
                         + " " + i[x].getClass());
    }
  }//end of main method
  
}//end of Of76 class

interface Nose {
  public int iMethod();
}//end of Nose interface

abstract class Picasso implements Nose {
    @Override
  public int iMethod() {
    return 7;
  }
}//end of abstract Picasso class


class Clowns extends Picasso {
}//end of Clowns class

class Acts extends Picasso {
    @Override
  public int iMethod() {
    return 5;
  }
}//end of Acts class