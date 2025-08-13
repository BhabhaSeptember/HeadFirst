package ch07;

//Subclass of Doctor class
public class Surgeon extends Doctor {

//inherits worksAtHospital instance variable from superclass

//inherits method below & overrides it to give Surgeon specific functionality   
  void treatPatient() {
    // perform surgery
  }

  
  void makeIncision() { //adds new, unique method
    // make incision (yikes!)
  }
}
