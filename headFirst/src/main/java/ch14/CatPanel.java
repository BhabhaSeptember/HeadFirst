package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class CatPanel extends JPanel implements ImageObserver {
    
    private Image image;
    
    //Constructor
    public CatPanel() {
//    image = new ImageIcon("cats.jpg").getImage();
    image = new ImageIcon(getClass().getResource("/ch14/cats.jpg")).getImage();

     MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(image, 0);
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
  public void paintComponent(Graphics g) {
       super.paintComponent(g); // important: clears and preps the panel
       
       
//Numbers are x and y co-ordinates for where the images top-left corner should
//be..The image is relative to JPanel subclass not JFrame
//i.e. 3px from left edge and 4px from top edge 
    g.drawImage(image, 3, 4, this);
  }

  public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
    return false;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.add(new CatPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}
