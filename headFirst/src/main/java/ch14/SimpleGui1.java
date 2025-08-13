package ch14;

import javax.swing.*;

public class SimpleGui1 {
  public static void main(String[] args) {
      
//make a JFrame and JButton 
//Pass button text in constructor
    JFrame frame = new JFrame();
    JButton button = new JButton("click me");

//Makes the program quit as soon as window is closed otherwise 
//it would sit on screen    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Add button to frames content pane    
    frame.getContentPane().add(button);

//Give frame size in pixels    
    frame.setSize(300, 300);

//Make fram visible otherwise it wont be displayed on the screen when code is run    
    frame.setVisible(true);
  }
}