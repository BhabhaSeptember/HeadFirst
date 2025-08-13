package ch03;

//SUMMARY:
//1) Arrays Defined:
//index[]: Holds integers that indicate the order in which to access islands
//islands[]: Holds the names of four islands.
//
//2) Loop (while y < 4):
//Uses index[y] to fetch the position from islands[].
//Prints the island name at that position.
//Increments y until it reaches 4.
class TestArrays {
  public static void main(String[] args) {
    int[] index = new int[4];
    index[0] = 1;
    index[1] = 3;
    index[2] = 0;
    index[3] = 2;
    
    String[] islands = new String[4];
    islands[0] = "Bermuda";
    islands[1] = "Fiji";
    islands[2] = "Azores";
    islands[3] = "Cozumel";
    
    int y = 0;
    int ref;
    while (y < 4) {
      ref = index[y];
      System.out.print("island = ");
      System.out.println(islands[ref]);
      y = y + 1;
    }
  }
} 