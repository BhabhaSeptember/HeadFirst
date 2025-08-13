package ch06;

import java.util.ArrayList;

public class SharpenYourPencil {
  void arrayListCode() {
      
//----- Page 134 Exercise -----
//Commented lines below refer to Regular Array column 
//i.e. what the code would be if using regular arrays instead of ArrayList

    ArrayList<String> myList = new ArrayList<String>();
    //String[] myList = new String[2];    

    String a = "whoohoo";
    //String a = "whoohoo";
    myList.add(a);
    //myList[0] = a;

    String b = "Frog";
    //String b = "Frog";
    myList.add(b);
    //myList[1] = b;

    int theSize = myList.size();
    //int theSize = myList.length;

    String str = myList.get(1);
    //String str = myList[1];

    myList.remove(1);
    //myList.pop();
    //---or----
    //myList[1] = null;

    boolean isIn = myList.contains(b);
    //boolean isIn = false;
    //for (String item : myList) {
    //  if ( b.equals(item) ) {
    //      isIn = true;
    //      break;
    //  }
    //}
  }

  void arrayCode() {
    String [] myList = new String[2];

    String a = "whoohoo";
    myList[0] = a;

    String b = "Frog";
    myList[1] = b;

    int theSize = myList.length;

    String str = myList[1];

    myList[1] = null;

    boolean isIn = false;
    for (String item : myList) {
      if (b.equals(item)) {
        isIn = true;
        break;
      }
    }
  }
}
