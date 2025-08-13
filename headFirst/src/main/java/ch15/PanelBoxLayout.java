package ch15;

import javax.swing.*;
import java.awt.*;

public class PanelBoxLayout {

  public static void main(String[] args) {
    PanelBoxLayout gui = new PanelBoxLayout();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);

//Change layout manager to new instance of BoxLayout which forces components to new line
//regardless of space available in the background component
//BoxLayout constructor takes the component to layout i.e. panel and
//it also specifies the axis to use i.e. Y_AXIS = vertical stack
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JButton button = new JButton("shock me");
    JButton buttonTwo = new JButton("bliss");
    panel.add(button);
    panel.add(buttonTwo);
    frame.getContentPane().add(BorderLayout.EAST, panel);
    frame.setSize(250,200);
    frame.setVisible(true);
  }

}
   