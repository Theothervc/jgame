package net.theothervc.jgame.components;

import net.theothervc.jgame.util.AspectRatio;
import net.theothervc.jgame.util.Images;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Component {
    public Dimension screenSize = new Dimension();
    public AspectRatio size;
    private float width;
    private float height;
    private float x;
    private float y;
    public Color color = Color.white;
    public BufferedImage appearance = null;

    public Component(float x,float y,float w,float h) {
        width = w;
        height = h;
        this.x = x;
        this.y = y;
    }

    public Component(float x,float y,float w,float h,Color color) {
        this(x,y,w,h);
        this.color = color;
    }

    public Component(int x,int y,int w,int h,String path) {
        this(x,y,w,h,Color.white);
        appearance = Images.getImageFromPath(path);
    }

    public void setAppearance(String path) {
        appearance = Images.getImageFromPath(path);
    }

    public void setAppearance(Color color) {
        appearance = null;
        this.color = color;
    }

    public int getWidth() {return (int) (screenSize.width*(width/1000));}

    public int getHeight() {return (int) (screenSize.height*(height/1000));}

    public int getX() {return (int) (screenSize.width*(x/1000));}

    public int getY() {return (int) (screenSize.height*(y/1000));}

    public void setSize(Dimension size) {
        width = size.width;
        height = size.height;
        this.size = AspectRatio.fromDimension(new Dimension(getWidth(),(int) (screenSize.width*(height/1000))));
    }

    public void setPos(Dimension pos) {
        x = pos.width;
        y = pos.height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
        this.size = AspectRatio.fromDimension(new Dimension(getWidth(),(int) (screenSize.width*(height/1000))));
    }

    public void setHeight(float height) {
        this.height = height;
        this.size = AspectRatio.fromDimension(new Dimension(getWidth(),(int) (screenSize.width*(height/1000))));
    }

    public void draw(Graphics g,Dimension screenSize) {
        this.screenSize = screenSize;
        if (size == null) this.size = AspectRatio.fromDimension(new Dimension(getWidth(),(int) (screenSize.width*(height/1000))));
        Dimension trueSize = size.fitToDimension(new Dimension(getWidth(),getHeight()));
        Dimension truePos = new Dimension(getX(),getY());
        if (appearance != null) {
            g.drawImage(appearance,truePos.width,truePos.height,trueSize.width,trueSize.height,null);
        } else {
            g.setColor(color);
            g.fillRect(truePos.width,truePos.height,trueSize.width,trueSize.height);
        }
    }

}
