/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch15;

import javax.swing.*;
import java.awt.*;

public class PanelFlowLayout {

    public static void main(String[] args) {
//Default layout manager for panel is FlowLayout     
        PanelFlowLayout gui = new PanelFlowLayout();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
//1) When the panel is empty it doesnt take up much width in the East region 
//
//2) The panel's layout manager (PanelFlowLayout) controls the button and
//frame's layout manager (Default is BorderLayout) controls the panel therefore
//the button will receive preferred size in both dimensions
        JButton button = new JButton("shock me");
        panel.add(button);

//3) Adding a second button to panel
//The panel expands to fit both buttons side by side. The second button has less letters
//so it will be smaller than the first because flow layout assigns size according to 
//what the component needs
        JButton buttonTwo = new JButton("bliss");
        panel.add(buttonTwo);
        
        JButton buttonThree = new JButton("huh?");
        panel.add(buttonThree);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

}
