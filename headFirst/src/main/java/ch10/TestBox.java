package ch10;

//----- Page 293 Exercise ----- 

public class TestBox {
  private Integer i; //default value is null
  private int j; //default value is 0

  public static void main(String[] args) {
    TestBox t = new TestBox();
    t.go();
  }

  public void go() {
//we try to assign an Integer object to a primitive int causing auto-unboxing
//but i is null, so unboxing 'null' to an int throws NullPointerException
    j = i;
    System.out.println(j);
    System.out.println(i);
  }
}