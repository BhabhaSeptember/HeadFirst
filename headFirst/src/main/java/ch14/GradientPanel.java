package ch14;

import javax.swing.*;
import java.awt.*;

//Graphics2D class reference can do more than a Graphics class reference
public class GradientPanel extends JPanel {
    
//parameter 'g' is a Graphics2D object that is being reference by Graphics class 
    @Override
  public void paintComponent(Graphics g) {
      
//casting parameter to Graphics2D to gain access to class-specific methods that are
//not available in Graphics class
    Graphics2D g2d = (Graphics2D) g; //Grphics2D is subclass of Graphics?

//First 3-args = Starting point and starting color
//Last 3-args = Ending point and ending color
    GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);

//Setting virtual paint brush to a gradient instead of a solid color    
    g2d.setPaint(gradient);
    
//fills the oval with the paintbursh i.e. the gradient    
    g2d.fillOval(70, 70, 100, 100);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.add(new GradientPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}
