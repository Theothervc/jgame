package net.theothervc.jgame.game;

import net.theothervc.jgame.util.Algorithms;

import javax.swing.*;
import java.awt.*;


public class Game {
    public JFrame window;
    public GameLoop loop;
    Dimension aspectRatio = new Dimension();

    public Game(String title, Dimension windowSize, GamePanelClass panel,GameLoop gameLoop) {
        window = new JFrame(title);
        window.setLocationRelativeTo(null);
        window.setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int gcf = Algorithms.euclid(windowSize.width,windowSize.height);
        aspectRatio.width = windowSize.width/gcf;
        aspectRatio.height = windowSize.height/gcf;
        window.setMinimumSize(new Dimension(aspectRatio.width*50,aspectRatio.height*50));
        window.setSize(windowSize);
        window.add(panel.frame);
        panel.parent = this;
        loop = gameLoop;
        gameLoop.parent = this;
        gameLoop.gamePanel = panel;
    }

    public void start() {
        window.setVisible(true);
        loop.start();
    }

}
