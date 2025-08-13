/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//----- Page 505 Exercise -----

//SUMMARY
//Creates a small GUI with a button that toggles its label between 
//"A" and "B" each time it is clicked.
//1)GUI Setup
//Creates a JFrame window.
//Adds a JButton with the starting label "A".
//Places the button at the bottom (SOUTH) of the frame.
//Sets the frame size to 200×100 and makes it visible.
//2) Event Handling
//Defines an inner class ButtonListener that implements ActionListener.
//actionPerformed() checks the current text of the button:
//If it’s "A", change it to "B".
//Otherwise, change it back to "A".
//3)Interaction
//Each button click triggers actionPerformed() and 
//flips the text between "A" and "B".
public class InnerButton {

    private JButton button;

    public static void main(String[] args) {
        InnerButton gui = new InnerButton();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button = new JButton("A");      
//The addActionListener( ) method takes a class that 
//implements the ActionListener interface.    
        button.addActionListener(new ButtonListener());
        
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(200, 100);
        frame.setVisible(true);
    }

    
//ActionListener is an interface; interfaces are implemented, not extended.
    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (button.getText().equals("A")) {
                button.setText("B");
            } else {
                button.setText("A");
            }
        }
    }

}
