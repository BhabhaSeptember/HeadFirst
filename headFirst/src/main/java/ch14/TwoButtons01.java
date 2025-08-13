/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//The main GUI class which doesnt implement ActionListener 
public class TwoButtons01 {

    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        TwoButtons01 gui = new TwoButtons01();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton labelButton = new JButton("Change Label");
//Register a new instance of the inner listener class instead of (this) - 
//[remember example where (this) referred to the main GUI class] 
        labelButton.addActionListener(new LabelListener());
        
        JButton colorButton = new JButton("Change Color");
        colorButton.addActionListener(new ColorListener());
        
        label = new JLabel("I’m a label");
        
        MyDrawPanel drawPanel = new MyDrawPanel();
        
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }//close go() method

//Inner class
//We have two ActionListeners in the same class as main GUI so listeners 
//both have access to main GUI variables and main GUI has access to
//the both listeners methods      
    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            label.setText("Ouch!");
        }
    }

//Inner class    
    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }

}//close outer class
