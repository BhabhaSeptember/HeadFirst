package ch14;

import javax.swing.*;

//Package has the ActionListener and ActionEvent
import java.awt.event.*;

//Interface says, 'an instance of SimpleGui2 IS-A ActionListener
//Button will give events only to ActionListener implementers
public class SimpleGui2 implements ActionListener {
  private JButton button;

  public static void main(String[] args) {
    SimpleGui2 gui = new SimpleGui2();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    button = new JButton("click me");
    
//Registering with the button to be added as one of its listeners
//The argument passed in must be an object from a class that 
//implements ActionListener interface
    button.addActionListener(this);

    frame.getContentPane().add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }//END OF GO() METHOD

//Implementing the actionPerformed() method from ActionListener interface
//This is the actual event-handling method  
  @Override
  public void actionPerformed(ActionEvent event) {
    button.setText("I've been clicked!");
  }
}