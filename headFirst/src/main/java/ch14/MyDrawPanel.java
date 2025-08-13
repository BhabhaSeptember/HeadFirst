package ch14;

import javax.swing.*; //JPanel, JFrame,
import java.awt.*; //Color
import java.util.Random;

//Make a subclass of JPanel which is a widget and we add our custom 
//'MyDrawPanel' widget to a JFrame
class MyDrawPanel extends JPanel {

//System calls paintComponent() method and passes it the drawing surface
//that is of type Graphics to paint
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//fillRect() will fill entire panel with black (default color)   
//First 2-args define upper-left corner (relative to panel) where drawing starts
//Other 2-args say: - make width & height of rectangle the same as (this) panel width & height
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        Random random = new Random();
//Using nextInt() method from java.util.Random library to get random number 
//between 0(inclusive) and max number, here = 256 (not inclusive)
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

//Creating a random color by passing 3 ints to represent RGB values 
//The Graphics drawing surface is drawn with the randomColor
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);

//Draw oval starting at 150px from left and 50px from top,
//the width and height of oval must both be 100px
//        g.fillOval(150, 50, 100, 100);

        g.fillRect(150, 100, 100, 100);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyDrawPanel());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
