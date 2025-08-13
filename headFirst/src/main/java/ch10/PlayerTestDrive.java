package ch10;

//NOTE: 
//All static variables in a class are initialized when a class is loaded, 
//before any object of that class can be created

class Player {
//declared but non-initialized static variables also receive the default,
//values for that variable type    
  static int playerCount = 0;
  private String name;
  

  public Player(String n) {
    name = n;
    playerCount++;
  }
}

public class PlayerTestDrive {
  public static void main(String[] args) {
    System.out.println(Player.playerCount);
    Player one = new Player("Tiger Woods");
    System.out.println(Player.playerCount);
    Player two = new Player("Bhabha September");
    System.out.println(Player.playerCount);
    
      
    
    
  }
}