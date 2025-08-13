package ch09;

public class TestLifeOne {
    
  public void read() {
      
//'s' is scoped to read() method only, it remains alive until end of method i.e,
//once stack execution of method completes, stack frame is popped off and,
//local variable dies
//When sleep() method is called, 's' local variable is still alive but not,
//in scope of sleep method. Only when execution is back to read() method, is
//'s' variable back in scope
    int s = 42; 
    sleep();
  }


  public void sleep() {
//    s = 7; //cannot use 's' variable here, it is out of sleep method scope
  }
}