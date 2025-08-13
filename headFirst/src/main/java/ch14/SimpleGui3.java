package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //EventListeners

public class SimpleGui3 implements ActionListener {
  private JFrame frame;

  public static void main(String[] args) {
    SimpleGui3 gui = new SimpleGui3();
    gui.go();
  }

  public void go() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton button = new JButton("Change colors");
//Register the gui object as a listener with/to event source    
    button.addActionListener(this);

//Refer to code in the MyDrawPanel class in ch14 package    
    MyDrawPanel drawPanel = new MyDrawPanel();

//2-arg add() method to specify region and widget to add    
    frame.getContentPane().add(BorderLayout.SOUTH, button);
    frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

//Implement listener interface by implementing its event-handling method
//Event object passed in carries info about event incl source of event  
@Override  
  public void actionPerformed(ActionEvent event) {
    frame.repaint();
  }
}






