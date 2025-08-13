package ch01;

import java.awt.*;
import java.awt.event.*;

class Party {
    
    public static void main(String[] args) {
        Party p = new Party();
        p.buildInvite();
    }//end of main method

    public void buildInvite() {
        Frame f = new Frame();
        Label l = new Label("Party at Tim's");
        Button b = new Button("You bet");
        Button c = new Button("Shoot me");

        Panel p = new Panel();
        p.add(l);
        p.add(b);
        p.add(c);

        f.add(p);
        f.setSize(300, 100);
        f.setVisible(true);

        // Optional: Add window close behavior
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }   // more code here...
}
