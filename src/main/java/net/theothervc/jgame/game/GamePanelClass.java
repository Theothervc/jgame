package net.theothervc.jgame.game;

import net.theothervc.jgame.util.Algorithms;
import net.theothervc.jgame.util.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class GamePanelClass {

    public JPanel frame;
    public JPanel canvas;
    public BufferedImage currentBackground = null;
    public boolean cropped = false;
    public Game parent = null;

    public JPanel getFrame() {
        return frame;
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public void setBackgroundStyle(Color color) {
        canvas.setBackground(color);
        currentBackground = null;
    }

    public void setBackgroundStyle(String imagepath,boolean crop) {
     currentBackground = Images.getImageFromPath(imagepath);
        cropped = crop;
    }


    protected void calculateBackground(Graphics g) {
        if (currentBackground != null) {
            if (cropped) {
                int gcf = Algorithms.euclid(currentBackground.getWidth(),currentBackground.getHeight());
                int w = 0;
                int h = 0;
                int x = 0;
                int y = 0;
                if (currentBackground.getWidth() > currentBackground.getHeight()) {
                    h = canvas.getHeight();
                    w = currentBackground.getWidth()*(h/(currentBackground.getHeight()/gcf));
                    x = (-currentBackground.getWidth())/2+canvas.getWidth()/2;
                } else {
                    w = canvas.getWidth();
                    h = currentBackground.getHeight()*(w/(currentBackground.getWidth()/gcf));
                    y = (-currentBackground.getHeight())/2+canvas.getHeight()/2;
                }
                g.drawImage(currentBackground,x,y,w,h,null);
            } else {
                g.drawImage(currentBackground,0,0,canvas.getWidth(),canvas.getHeight(),null);
            }
        }
    }

}
