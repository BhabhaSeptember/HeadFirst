package ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea1 {
  public static void main(String[] args) {
    TextArea1 gui = new TextArea1();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JButton button = new JButton("Just Click It");

//text area object using constructor that takes 
//height(10 lines) and width(20 col) as arguments 
    JTextArea text = new JTextArea(10, 20);
//turn on line wrapping    
    text.setLineWrap(true);
//Lambda expression to implement the buttons ActionListener upon receiving ActionEvent    
//insert new line with '\n' so text appears in new line each time button is clicked
button.addActionListener(e -> text.append("button clicked \n"));

//Make JScrollPane object and pass the component/text area that it will be scrolling for    
    JScrollPane scroller = new JScrollPane(text);
//Tell scroll pan to use only the vertical scroll bar  
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

//Add scroll pane to panel with the text area in it i.e. dont add text area directly
//to panel
    panel.add(scroller);

    frame.getContentPane().add(BorderLayout.CENTER, panel);
    frame.getContentPane().add(BorderLayout.SOUTH, button);

    frame.setSize(350, 300);
    frame.setVisible(true);
  }
}
      








       