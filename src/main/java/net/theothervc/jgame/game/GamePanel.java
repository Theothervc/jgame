package net.theothervc.jgame.game;


import org.cef.OS;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends GamePanelClass {

    public GamePanel() {
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (OS.isLinux()) Toolkit.getDefaultToolkit().sync();
                super.paintComponent(g);
                calculateBackground(g);
                parent.loop.currentScene.draw(g);
            }
        };
        canvas.setBackground(Color.WHITE);
        canvas.setFocusable(true);
        canvas.setDoubleBuffered(true);
        frame = new JPanel(new BorderLayout());
        frame.setBackground(Color.BLACK);
        frame.add(canvas);
    }


}
