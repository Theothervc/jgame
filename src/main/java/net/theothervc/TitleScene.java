package net.theothervc;

import net.theothervc.jgame.components.ImageComponent;
import net.theothervc.jgame.game.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TitleScene implements Scene, KeyListener {

    ImageComponent rect = new ImageComponent(100,100,100,100,Color.BLACK);


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g,Dimension screenSize) {
        rect.draw(g,screenSize);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
