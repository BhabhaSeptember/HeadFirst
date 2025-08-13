package ch15;

import javax.swing.*;
import java.awt.*; //BorderLayout (Layout Manager)

public class Button1 {

    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();

//1)        
//    JButton east = new JButton("East");
//2) Below component now occupies a larger width in the frame but the height still
//remains the same as the layouts east region height
        JButton east = new JButton("Click like you mean it!");

//West region components behave like that of East region components i.e.
//Recieve preferred width but keep frame region height
        JButton west = new JButton("West");

//1)
//      JButton north = new JButton("North");
//
//2) The component below can be as tall as it wants to be but will remain the same
//width as the region/frame
//        JButton north = new JButton("There is no spoon...");
//
//3) Making the button as tall as it wants to be
        JButton north = new JButton("North - Specified height");
//Bigger font will force the frame to allocate more space for the components height        
        Font bigFont = new Font("serif", Font.BOLD, 28);
        north.setFont(bigFont);

//South region component height and width behave like that of North region i.e.
//gets preferred height but keeps frame width
        JButton south = new JButton("South");
        
//Center region components receive leftover height and region according to 
//tehe set frame size dimensions
        JButton center = new JButton("Center");

        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.CENTER, center);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
