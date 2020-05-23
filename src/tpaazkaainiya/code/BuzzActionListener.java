/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpaazkaainiya.code;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author Jabrikos
 */
public class BuzzActionListener {
    
    JFrame frame;
    Point currLocation;
    int iDisplaceXBy = 5;
    int iDisplaceYBy = -10;

    public BuzzActionListener(JFrame frame) {
        this.frame = frame;
    }
    
    public BuzzActionListener() {
    }

    
    public void actionPerformed() {
        currLocation = frame.getLocationOnScreen();
        
        Point position1 = new Point (currLocation.x + iDisplaceXBy, currLocation.y + iDisplaceYBy);
        Point position2 = new Point (currLocation.x - iDisplaceXBy, currLocation.y - iDisplaceYBy);
        
        for (int i = 0; i < 20; i++) {
            frame.setLocation(position1);
            frame.setLocation(position2);
        }
        frame.setLocation(currLocation); 
    }

    void actionPerformed(MouseEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
