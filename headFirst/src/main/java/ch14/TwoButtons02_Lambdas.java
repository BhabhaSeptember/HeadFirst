package ch14;

import javax.swing.*;
import java.awt.*;

public class TwoButtons02_Lambdas { //outer class
  private JFrame frame;
  private JLabel label;

  public static void main(String[] args) {
    TwoButtons02_Lambdas gui = new TwoButtons02_Lambdas();
    gui.go();
  }

  public void go() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton labelButton = new JButton("Change Label");  
//ActionListener is a functional interface so we can replace the inner 
//class with a lambda expression for the method from the listener interface
    labelButton.addActionListener(event -> label.setText("Ouch!"));

    JButton colorButton = new JButton("Change Circle");
    colorButton.addActionListener(event -> frame.repaint());

    label = new JLabel("I’m a label");
    MyDrawPanel drawPanel = new MyDrawPanel();

    frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
    frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
    frame.getContentPane().add(BorderLayout.EAST, labelButton);
    frame.getContentPane().add(BorderLayout.WEST, label);

    frame.setSize(500, 400);
    frame.setVisible(true);
  }
}
