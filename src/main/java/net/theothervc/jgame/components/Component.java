package net.theothervc.jgame.components;

import net.theothervc.jgame.util.Images;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Component {

    int width;
    int height;
    int x;
    int y;
    public Color color = Color.white;
    public BufferedImage appearance = null;


    public Component(int x,int y,int w,int h,Color color) {
        width = w;
        height = h;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Component(int x,int y,int w,int h,String path) {
        this(x,y,w,h,Color.white);
        appearance = Images.getImageFromPath(path);
    }

    public void setAppearance(String path) {

    }

    public void setAppearance(Color color) {

    }

    public int getWidth() {return width;}

    public int getHeight() {return height;}

    public void draw() {

    }

}
