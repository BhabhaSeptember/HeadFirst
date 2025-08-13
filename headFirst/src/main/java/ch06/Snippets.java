package ch06;

import java.util.ArrayList;

public class Snippets {
  void arrayList() {
//Create new ArrayList object of Egg objects      
    ArrayList<Egg> myList = new ArrayList<Egg>();

//Create an Egg object and add it to ArrayList    
    Egg egg1 = new Egg();
    myList.add(egg1);

//Create another Egg object and add that to ArrayList    
    Egg egg2 = new Egg();
    myList.add(egg2);

//Return the number of elements in the ArrayList (i.e. 2)    
    int theSize = myList.size();

//Check if ArrayList contains specified object reference (true or false)    
    boolean isIn = myList.contains(egg1);

//Return index of first occurence of egg2 object reference (i.e. 1)    
    int idx = myList.indexOf(egg2);

    
//Check if ArrayList is empty (true or false)    
    boolean empty = myList.isEmpty();

//Remove/delete specified object reference. ArrayList shrinks    
    myList.remove(egg1);
  }

  void andExample(int price, String camera) {
    if (price >= 300 && price < 400) {
      camera = "X";
    }
  }

  void orExample(String brand) {
    if (brand.equals("A") || brand.equals("B")) {
      // do stuff for only brand A or brand B
    }
  }

  void longBoolean(String zoomType, int zoomDegree) {
    if ((zoomType.equals("optical") &&
         (zoomDegree >= 3 && zoomDegree <= 8)) ||
        (zoomType.equals("digital") &&
         (zoomDegree >= 5 && zoomDegree <= 12))) {
      // do appropriate zoom stuff
    }
  }

  void notEqualInt(int model) {
    if (model != 2000) {
      //  do non-model 2000 stuff
    }
  }

  void notEqualString(String brand) {
    if (!brand.equals("X")) {
      // do non-brand X stuff
    }
  }

  void shortCircuit(SomeType refVar) {
    if (refVar != null &&
        refVar.isValidType()) {
      // do ‘got a valid type’ stuff
    }
  }

  void arrayListComparedToArray(String[] myList) {
    String b = new String("Frog");

    boolean isIn = false;
    for (String item : myList) {
      if (b.equals(item)) {
        isIn = true;
        break;
      }
    }
  }

  private class SomeType {
    public boolean isValidType() {
      return false;
    }
  }
}
