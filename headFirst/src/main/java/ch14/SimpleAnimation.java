package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SimpleAnimation { //outer class
//Instance variables for x-y co-ordinates of circle    
  private int xPos = 70;
  private int yPos = 70;

  public static void main(String[] args) {
    SimpleAnimation gui = new SimpleAnimation();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MyDrawPanel drawPanel = new MyDrawPanel();

    frame.getContentPane().add(drawPanel);
    frame.setSize(300, 300);
    frame.setVisible(true);
   
    for (int i = 0; i < 130; i++) { //repeats 130times
      xPos++;
      yPos++;

//Panel repaints itself      
      drawPanel.repaint();

      try {
        TimeUnit.MILLISECONDS.sleep(50); //pause between repaints
      } catch (Exception e) {
        e.printStackTrace();
      }
    }//end of for-loop
  }

  class MyDrawPanel extends JPanel { //inner class
      
      @Override
    public void paintComponent(Graphics g) {
//For animation effect, the panel is continually painted white as the 
//paintComponent is being called by system. Then it repaints the circle 
//in the continually changing x,y-positions
      g.setColor(Color.white);     
//getWidth() and getHeight() methods are inherited from JPanel
      g.fillRect(0, 0, this.getWidth(), this.getHeight());

      g.setColor(Color.green);
//uses continually updated x,y co-ordinates from the outer class
      g.fillOval(xPos, yPos, 40, 40); 
    }
  }
  
} 