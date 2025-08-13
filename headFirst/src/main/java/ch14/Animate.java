package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

//SUMMARY: 
//This program creates a simple Swing animation where a blue rectangle 
//shrinks inward over time.

//1) Initial Setup
//Creates a JFrame window.
//Adds a custom JPanel (MyDrawP) for drawing.
//Sets the window size to 500×270 and makes it visible.
//2) Animation Loop
//Variables x and y (starting at 1) control the rectangle’s top-left 
//position and how much it shrinks.
//A for loop runs 124 times, incrementing both x and y each frame.
//After each increment, drawP.repaint() is called to redraw the panel.
//The loop pauses 50 milliseconds between frames to control the 
//animation speed.
//3) Drawing Logic (paintComponent)
//Fills the panel with a white background.
//Draws a blue rectangle starting at (x, y) and ending at 
//(500 - x*2, 250 - y*2).
//As x and y increase, the rectangle gets smaller and more centered
public class Animate {
  int x = 1;
  int y = 1;

  public static void main(String[] args) {
    Animate gui = new Animate();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
    MyDrawP drawP = new MyDrawP();
    frame.getContentPane().add(drawP);
    frame.setSize(500, 270);
    frame.setVisible(true);
    for (int i = 0; i < 124; i++, y++, x++) {
      x++;
      drawP.repaint();
      try {
        TimeUnit.MILLISECONDS.sleep(50);
      } catch (Exception ex) {
      }
    }
  }

  class MyDrawP extends JPanel {
    public void paintComponent(Graphics g) {
      g.setColor(Color.white);
      g.fillRect(0, 0, 500, 250);
      g.setColor(Color.blue);
      g.fillRect(x, y, 500 - x * 2, 250 - y * 2);
    }
  }
}